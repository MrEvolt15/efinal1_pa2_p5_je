package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Propietario;

public interface IPropietarioService {
    public void guardar(Propietario propietario);
    public Propietario buscarPorId(Integer id);
    public void actualizar(Propietario propietario);
    public void borrar(Integer id);
}
