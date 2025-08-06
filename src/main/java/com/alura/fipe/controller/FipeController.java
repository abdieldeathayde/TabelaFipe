package com.alura.fipe.controller;

import com.alura.fipe.dto.FipeRequest;
import com.alura.fipe.service.ConsumoApi;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fipe")
public class FipeController {

    private final String URL = "https://veiculos.fipe.org.br/api/veiculos/ConsultarValorComTodosParametros";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping
    public ResponseEntity<?> consultarFipe(@RequestBody FipeRequest req) {
        try {
            // Montar JSON manualmente ou usar ObjectMapper
            String jsonBody = objectMapper.writeValueAsString(new Object() {
                public final int codigoTabelaReferencia = 296;
                public final Object codigoMarca = null;
                public final Object codigoModelo = null;
                public final int anoModelo = req.getAnoModelo();
                public final int codigoTipoCombustivel = req.getCodigoTipoCombustivel();
                public final int tipoVeiculo = req.getTipoVeiculo();
                public final String tipoConsulta = "tradicional";
                public final String codigoFipe = req.getCodigoFipe();
            });

            ConsumoApi consumoApi = new ConsumoApi();
            String json = consumoApi.postJson(URL, jsonBody);

            JsonNode responseJson = objectMapper.readTree(json);
            return ResponseEntity.ok(responseJson);

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro: " + e.getMessage());
        }
    }
}
