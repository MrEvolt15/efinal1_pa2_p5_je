package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITrasnferenciaService{
    @Autowired
    private ITransferenciaRepository iTransferenciaRepository;
    @Autowired
    private ICuentaBancariaRepository bancariaRepository;

    @Override
    public void realizar(String ctaOrigen, String ctaDestino, BigDecimal monto) {
        //Buscar las Cuentas
        CuentaBancaria cO = this.bancariaRepository.seleccionarPorNumero(ctaOrigen);
        CuentaBancaria cD = this.bancariaRepository.seleccionarPorNumero(ctaDestino);
        BigDecimal comision = monto.multiply(BigDecimal.valueOf(0.1));
        BigDecimal resultante = cO.getSaldo().subtract(monto);
        resultante.subtract(comision);
        //Monto Restado y Asignado
        if(resultante.compareTo(BigDecimal.valueOf(0))>=0){
            BigDecimal nuevoSaldo =cO.getSaldo().subtract(monto);
            cD.setSaldo(nuevoSaldo);
            //Creacion de la Transferencia
            Transferencia trans = new Transferencia();
            trans.setFecha(LocalDate.now());
            trans.setMonto(monto);
            trans.setComision(comision);
            trans.setCuentaBancariaOrigen(cO);
            trans.setCuentaBancariaDestino(cD);

            this.iTransferenciaRepository.insertar(trans);
            
            cO.setSaldo(cO.getSaldo().subtract(comision));
            cD.setSaldo(cD.getSaldo().add(monto));
            this.bancariaRepository.actualizar(cO);
        }else{
            System.out.println("Transferencia no realizada, saldo insuficiente");
        }
        

    }

    @Override
    public List<Transferencia> reporteTodo() {
        return this.iTransferenciaRepository.seleccionarTodo();
    }

}
