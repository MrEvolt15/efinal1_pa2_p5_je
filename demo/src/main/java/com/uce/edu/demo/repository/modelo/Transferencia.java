package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "transferencia")
public class Transferencia {
    @Id
    @GeneratedValue(generator = "seq_transferencia",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="seq_transferencia",sequenceName ="seq_transferencia",allocationSize = 1 )
    @Column(name = "trans_id")
    private Integer id;
    @Column(name = "trans_fecha")
    private LocalDate fecha;
    @Column(name = "trans_monto")
    private BigDecimal monto;
    @Column(name = "trans_comision")
    private BigDecimal comision;

    @ManyToOne()
    @JoinColumn(name = "ctaO_trans_id")
    private CuentaBancaria cuentaBancariaOrigen;
    @ManyToOne()
    @JoinColumn(name="ctaD_trans_id")
    private CuentaBancaria cuentaBancariaDestino;
    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public BigDecimal getMonto() {
        return monto;
    }
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    public BigDecimal getComision() {
        return comision;
    }
    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }
    public CuentaBancaria getCuentaBancariaOrigen() {
        return cuentaBancariaOrigen;
    }
    public void setCuentaBancariaOrigen(CuentaBancaria cuentaBancariaOrigen) {
        this.cuentaBancariaOrigen = cuentaBancariaOrigen;
    }
    public CuentaBancaria getCuentaBancariaDestino() {
        return cuentaBancariaDestino;
    }
    public void setCuentaBancariaDestino(CuentaBancaria cuentaBancariaDestino) {
        this.cuentaBancariaDestino = cuentaBancariaDestino;
    }
   
    
}

