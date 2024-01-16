package com.uce.edu.demo.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(CuentaBancaria cuentaBancaria) {
        this.entityManager.persist(cuentaBancaria);
    }

    @Override
    public CuentaBancaria seleccionarPorId(Integer id) {
      return this.entityManager.find(CuentaBancaria.class, id);
    }

    @Override
    public void actualizar(CuentaBancaria cuentaBancaria) {
       this.entityManager.merge(cuentaBancaria);
    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(this.seleccionarPorId(id));
    }

    @Override
    public CuentaBancaria seleccionarPorNumero(String numero) {
       TypedQuery<CuentaBancaria> myQuery = this.entityManager.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numero = :numero",CuentaBancaria.class);
       myQuery.setParameter("numero", numero);
       return myQuery.getSingleResult();
    }

}
