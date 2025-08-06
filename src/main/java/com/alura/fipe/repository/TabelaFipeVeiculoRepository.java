package com.alura.fipe.repository;

import com.alura.fipe.model.TabelaFipeVeiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TabelaFipeVeiculoRepository extends JpaRepository<TabelaFipeVeiculo, Long> {
    Page<TabelaFipeVeiculo> findByMarcaContainingIgnoreCase(String marca, Pageable pageable);
    Page<TabelaFipeVeiculo> findByModeloContainingIgnoreCase(String modelo, Pageable pageable);
    Page<TabelaFipeVeiculo> findByMarcaContainingIgnoreCaseAndModeloContainingIgnoreCase(String marca, String modelo, Pageable pageable);
}
