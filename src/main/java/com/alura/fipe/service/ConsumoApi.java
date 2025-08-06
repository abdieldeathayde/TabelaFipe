package com.alura.fipe.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumoApi {

    private final RestTemplate restTemplate = new RestTemplate();

    public JsonNode obterDadosVeiculo(String marcaId, String modeloId, String anoId) {
        String url = String.format("https://parallelum.com.br/fipe/api/v1/carros/marcas/%s/modelos/%s/anos/%s",
                marcaId, modeloId, anoId);
        return restTemplate.getForObject(url, JsonNode.class);
    }
}
