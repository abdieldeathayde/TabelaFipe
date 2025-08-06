package com.alura.fipe.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tabela_fipe_veiculo")
public class TabelaFipeVeiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mesReferencia;

    private String codigoFipe;

    private String marca;

    private String modelo;

    private String anoModelo;

    private String autenticacao;

    private String dataConsulta;

    private String precoMedio;

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public void setCodigoFipe(String codigoFipe) {
        this.codigoFipe = codigoFipe;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(String anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getAutenticacao() {
        return autenticacao;
    }

    public void setAutenticacao(String autenticacao) {
        this.autenticacao = autenticacao;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getPrecoMedio() {
        return precoMedio;
    }

    public void setPrecoMedio(String precoMedio) {
        this.precoMedio = precoMedio;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    private LocalDateTime dataRegistro = LocalDateTime.now();

    // Getters e Setters
}
