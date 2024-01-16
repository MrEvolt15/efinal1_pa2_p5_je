package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Propietario;

public interface IPropietarioRepository {
    public void insertar(Propietario propietario);
    public Propietario seleccionarPorId(Integer id);
    public void actualizar(Propietario propietario);
    public void eliminar(Integer id);
}
