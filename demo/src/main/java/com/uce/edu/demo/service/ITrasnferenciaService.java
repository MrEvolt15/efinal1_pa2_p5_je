package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Transferencia;

public interface ITrasnferenciaService {
    public void realizar(String ctaOrigen, String ctaDestino, BigDecimal monto);
    public List<Transferencia> reporteTodo();
}
