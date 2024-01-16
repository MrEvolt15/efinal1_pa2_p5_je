package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPropietarioRepository;
import com.uce.edu.demo.repository.modelo.Propietario;

@Service
public class PropietarioServiceImpl implements IPropietarioRepository{
    @Autowired
    private IPropietarioRepository iPropietarioRepository;

    @Override
    public void insertar(Propietario propietario) {
       this.iPropietarioRepository.insertar(propietario);
    }

    @Override
    public Propietario seleccionarPorId(Integer id) {
       return this.iPropietarioRepository.seleccionarPorId(id);
    }

    @Override
    public void actualizar(Propietario propietario) {
        this.iPropietarioRepository.actualizar(propietario);
    }

    @Override
    public void eliminar(Integer id) {
        this.iPropietarioRepository.eliminar(id);
    }

}
