package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Transferencia;

public interface ITransferenciaRepository {
    public void insertar(Transferencia transferencia);
    public List<Transferencia> seleccionarTodo();
}
