package com.alura.fipe.controller;

import com.alura.fipe.model.TabelaFipeVeiculo;
import com.alura.fipe.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fipe")
public class TabelaFipeController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    // 🔍 READ - listar todos
    @GetMapping("/veiculos")
    public ResponseEntity<List<TabelaFipeVeiculo>> listarTodos() {
        List<TabelaFipeVeiculo> veiculos = veiculoRepository.findAll();
        return ResponseEntity.ok(veiculos);
    }

    // 🔍 READ - buscar por ID
    @GetMapping("/veiculos/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<TabelaFipeVeiculo> veiculo = veiculoRepository.findById(id);
        return veiculo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ CREATE - cadastrar novo
    @PostMapping("/veiculos")
    public ResponseEntity<TabelaFipeVeiculo> cadastrar(@RequestBody TabelaFipeVeiculo veiculo) {
        veiculo.setDataRegistro(LocalDateTime.now());
        veiculo.setDataConsulta(LocalDateTime.now());
        TabelaFipeVeiculo salvo = veiculoRepository.save(veiculo);
        return ResponseEntity.ok(salvo);
    }

    // 🔄 UPDATE - atualizar veículo
    @PutMapping("/veiculos/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody TabelaFipeVeiculo atualizado) {
        Optional<TabelaFipeVeiculo> veiculoOptional = veiculoRepository.findById(id);

        if (veiculoOptional.isPresent()) {
            TabelaFipeVeiculo existente = veiculoOptional.get();

            existente.setCodigoFipe(atualizado.getCodigoFipe());
            existente.setMarca(atualizado.getMarca());
            existente.setModelo(atualizado.getModelo());
            existente.setAnoModelo(atualizado.getAnoModelo());
            existente.setPrecoMedio(atualizado.getPrecoMedio());
            existente.setMesReferencia(atualizado.getMesReferencia());
            existente.setDataConsulta(LocalDateTime.now());

            veiculoRepository.save(existente);
            return ResponseEntity.ok(existente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ❌ DELETE - deletar veículo
    @DeleteMapping("/veiculos/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if (veiculoRepository.existsById(id)) {
            veiculoRepository.deleteById(id);
            return ResponseEntity.ok("Veículo deletado com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
