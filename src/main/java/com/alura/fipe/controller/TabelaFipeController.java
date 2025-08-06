package com.alura.fipe.controller;

import com.alura.fipe.dto.FipeResponse;
import com.alura.fipe.model.TabelaFipeVeiculo;
import com.alura.fipe.repository.TabelaFipeVeiculoRepository;
import com.alura.fipe.service.ConsumoApi;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fipe")
public class TabelaFipeController {

    private final ConsumoApi consumoApi;
    private final ObjectMapper objectMapper;
    private final TabelaFipeVeiculoRepository tabelaFipeVeiculoRepository;

    public TabelaFipeController(ConsumoApi consumoApi,
                                ObjectMapper objectMapper,
                                TabelaFipeVeiculoRepository tabelaFipeVeiculoRepository) {
        this.consumoApi = consumoApi;
        this.objectMapper = objectMapper;
        this.tabelaFipeVeiculoRepository = tabelaFipeVeiculoRepository;
    }

    // Consulta com filtros e paginação
    @GetMapping("/buscar")
    public List<TabelaFipeVeiculo> buscar(
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String modelo,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Pageable pageable = PageRequest.of(
                page,
                size,
                direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC,
                sortBy
        );

        Page<TabelaFipeVeiculo> resultado;

        if (marca != null && modelo != null) {
            resultado = tabelaFipeVeiculoRepository.findByMarcaContainingIgnoreCaseAndModeloContainingIgnoreCase(marca, modelo, pageable);
        } else if (marca != null) {
            resultado = tabelaFipeVeiculoRepository.findByMarcaContainingIgnoreCase(marca, pageable);
        } else if (modelo != null) {
            resultado = tabelaFipeVeiculoRepository.findByModeloContainingIgnoreCase(modelo, pageable);
        } else {
            resultado = tabelaFipeVeiculoRepository.findAll(pageable);
        }

        return resultado.getContent();
    }

    // Consulta na API externa da FIPE e salva no banco
    @GetMapping("/{marca}")
    public FipeResponse buscarPorMarca(@PathVariable String marca) {
        String endereco = "https://parallelum.com.br/fipe/api/v1/carros/marcas/" + marca + "/modelos/147/anos/1987-1";
        String json = consumoApi.obterDados(endereco);

        try {
            JsonNode responseJson = objectMapper.readTree(json);
            FipeResponse fipe = objectMapper.treeToValue(responseJson, FipeResponse.class);

            TabelaFipeVeiculo entidade = new TabelaFipeVeiculo();
            entidade.setMesReferencia(fipe.getMesReferencia());
            entidade.setCodigoFipe(fipe.getCodigoFipe());
            entidade.setMarca(fipe.getMarca());
            entidade.setModelo(fipe.getModelo());
            entidade.setAnoModelo(fipe.getAnoModelo());
            entidade.setAutenticacao(fipe.getAutenticacao());
            entidade.setDataConsulta(fipe.getDataConsulta());
            entidade.setPrecoMedio(fipe.getPrecoMedio());

            tabelaFipeVeiculoRepository.save(entidade);

            return fipe;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao processar resposta da API FIPE", e);
        }
    }

    // Lista todos os veículos salvos no banco
    @GetMapping
    public List<TabelaFipeVeiculo> listarTodos() {
        return tabelaFipeVeiculoRepository.findAll();
    }
}
