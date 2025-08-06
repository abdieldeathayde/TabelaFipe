package com.alura.fipe.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FipeRequest {
    // Getters e Setters
    private int tipoVeiculo;
    private String codigoFipe;
    private int anoModelo;
    private int codigoTipoCombustivel;
    private String autenticacao;

}