package com.alura.fipe.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tabela_fipe_veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String autenticacao;
    private String codigoFipe;
//    @Column(name = "ano_modelo", nullable = false)
    private int anoModelo;
    private int codigoTipoCombustivel;
    private LocalDate dataConsulta;
    private LocalDateTime dataRegistro;
    private String marca;
    private String mesReferencia;
    private String modelo;
    private double precoMedio;
    private String tipoVeiculo;

    // Gera automaticamente o valor de 'autenticacao' antes de inserir no banco
    @PrePersist
    public void gerarAutenticacao() {
        if (this.autenticacao == null || this.autenticacao.isBlank()) {
            this.autenticacao = UUID.randomUUID().toString();
        }
        if (this.dataRegistro == null) {
            this.dataRegistro = LocalDateTime.now();
        }
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public String getAutenticacao() {
        return autenticacao;
    }

    public void setAutenticacao(String autenticacao) {
        this.autenticacao = autenticacao;
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

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecoMedio() {
        return precoMedio;
    }

    public void setPrecoMedio(double precoMedio) {
        this.precoMedio = precoMedio;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }
}
