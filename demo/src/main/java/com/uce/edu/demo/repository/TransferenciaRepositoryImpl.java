package com.uce.edu.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TransferenciaRepositoryImpl implements ITransferenciaRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void insertar(Transferencia transferencia) {
       this.entityManager.persist(transferencia);
    }

    @Override
    public List<Transferencia> seleccionarTodo() {
        TypedQuery<Transferencia> myQuery = this.entityManager.createQuery("SELECT t FROM Transferencia t",Transferencia.class);
        return myQuery.getResultList();
    }

}
