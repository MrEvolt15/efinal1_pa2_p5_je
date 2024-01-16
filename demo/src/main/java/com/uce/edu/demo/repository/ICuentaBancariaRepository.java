package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {
    public void insertar(CuentaBancaria cuentaBancaria);
    public CuentaBancaria seleccionarPorId(Integer id);
    public void actualizar(CuentaBancaria cuentaBancaria);
    public void eliminar(Integer id);
    public CuentaBancaria seleccionarPorNumero(String numero);
}
