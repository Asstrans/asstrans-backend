package com.asstrans.agremiados.dto;


import java.math.BigDecimal;
import java.util.Objects;

public class RequisicaoMesAssociado {

    private Long id_requisicao;
    private Double valor_total;
    private Double valor_parcela;
    private Long id_associado;
    private String nome_associado;
    private Double salario_associado;
    private Long id_convenio;
    private String nome_convenio;


    public RequisicaoMesAssociado() {}

    public RequisicaoMesAssociado(Long id_requisicao, Double valor_total, Double valor_parcela, Long id_associado, String nome_associado, Double salario_associado, Long id_convenio, String nome_convenio) {
        this.id_requisicao = id_requisicao;
        this.valor_total = valor_total;
        this.valor_parcela = valor_parcela;
        this.id_associado = id_associado;
        this.nome_associado = nome_associado;
        this.salario_associado = salario_associado;
        this.id_convenio = id_convenio;
        this.nome_convenio = nome_convenio;
    }

    public Long getId_requisicao() {
        return id_requisicao;
    }

    public void setId_requisicao(Long id_requisicao) {
        this.id_requisicao = id_requisicao;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    public Double getValor_parcela() {
        return valor_parcela;
    }

    public void setValor_parcela(Double valor_parcela) {
        this.valor_parcela = valor_parcela;
    }

    public Long getId_associado() {
        return id_associado;
    }

    public void setId_associado(Long id_associado) {
        this.id_associado = id_associado;
    }

    public String getNome_associado() {
        return nome_associado;
    }

    public void setNome_associado(String nome_associado) {
        this.nome_associado = nome_associado;
    }

    public Double getSalario_associado() {
        return salario_associado;
    }

    public void setSalario_associado(Double salario_associado) {
        this.salario_associado = salario_associado;
    }

    public Long getId_convenio() {
        return id_convenio;
    }

    public void setId_convenio(Long id_convenio) {
        this.id_convenio = id_convenio;
    }

    public String getNome_convenio() {
        return nome_convenio;
    }

    public void setNome_convenio(String nome_convenio) {
        this.nome_convenio = nome_convenio;
    }
}
