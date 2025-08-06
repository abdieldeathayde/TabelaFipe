package com.alura.fipe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FipeResponse {

    @JsonProperty("CodigoFipe")
    private String codigoFipe;

    @JsonProperty("Marca")
    private String marca;

    @JsonProperty("Modelo")
    private String modelo;

    @JsonProperty("AnoModelo")
    private int anoModelo;

    @JsonProperty("Valor")
    private String preco;

    @JsonProperty("MesReferencia")
    private String mesReferencia;

    // Getters e setters
}
