package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
    public void guardar(CuentaBancaria cuentaBancaria);
    public CuentaBancaria buscarPorId(Integer id);
    public void actualizar(CuentaBancaria cuentaBancaria);
    public void borrar(Integer id);
    public CuentaBancaria buscarPorNumero(String numero);
}
