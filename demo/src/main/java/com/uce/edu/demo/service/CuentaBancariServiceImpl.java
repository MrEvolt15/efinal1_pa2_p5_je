package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariServiceImpl implements ICuentaBancariaService{
    @Autowired
    private ICuentaBancariaRepository bancariaRepository;

    @Override
    public void guardar(CuentaBancaria cuentaBancaria) {
        this.bancariaRepository.insertar(cuentaBancaria);
    }

    @Override
    public CuentaBancaria buscarPorId(Integer id) {
       return this.bancariaRepository.seleccionarPorId(id);
    }

    @Override
    public void borrar(Integer id) {
        this.bancariaRepository.eliminar(id);;
    }

    @Override
    public void actualizar(CuentaBancaria cuentaBancaria) {
        this.bancariaRepository.actualizar(cuentaBancaria);
    }

    @Override
    public CuentaBancaria buscarPorNumero(String numero) {
        return this.bancariaRepository.seleccionarPorNumero(numero);
    }
}
