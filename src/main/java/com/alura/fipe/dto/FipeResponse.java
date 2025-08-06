package com.alura.fipe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FipeResponse {

    @JsonProperty("MesReferencia")
    private String mesReferencia;

    @JsonProperty("CodigoFipe")
    private String codigoFipe;

    @JsonProperty("Marca")
    private String marca;

    @JsonProperty("Modelo")
    private String modelo;

    @JsonProperty("AnoModelo")
    private String anoModelo; // vem como "1987 Gasolina", então é String

    @JsonProperty("Autenticacao")
    private String autenticacao;

    @JsonProperty("DataConsulta")
    private String dataConsulta;

    @JsonProperty("Valor")
    private String precoMedio; // chamado de "Valor" na API

    public String getMesReferencia() {
        return mesReferencia;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAnoModelo() {
        return anoModelo;
    }

    public String getAutenticacao() {
        return autenticacao;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public String getPrecoMedio() {
        return precoMedio;
    }

    // Getters e Setters
}
