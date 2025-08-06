package com.alura.fipe.dto;

public class FipeRequest {
    private int tipoVeiculo;
    private String codigoFipe;
    private int anoModelo;
    private int codigoTipoCombustivel;

    // Getters e Setters
    public int getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(int tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public void setCodigoFipe(String codigoFipe) {
        this.codigoFipe = codigoFipe;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public int getCodigoTipoCombustivel() {
        return codigoTipoCombustivel;
    }

    public void setCodigoTipoCombustivel(int codigoTipoCombustivel) {
        this.codigoTipoCombustivel = codigoTipoCombustivel;
    }
}