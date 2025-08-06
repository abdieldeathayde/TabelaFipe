package com.alura.fipe.repository;

import com.alura.fipe.entity.Veiculo;
import com.alura.fipe.model.TabelaFipeVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<TabelaFipeVeiculo, Long> {}

