package com.asstrans.agremiados.dto;

public class PlanoAssociadoDependenteAll {

    private Long id_associado;
    private String nome_associado;
    private Long id_dependente;
    private String nome_dependente;
    private Long id_plano;
    private Double valor_plano;
    private String nome_plano;

    public PlanoAssociadoDependenteAll() {}

    public PlanoAssociadoDependenteAll(Long id_associado, String nome_associado, Long id_dependente, String nome_dependente, Long id_plano, Double valor_plano, String nome_plano) {
        this.id_associado = id_associado;
        this.nome_associado = nome_associado;
        this.id_dependente = id_dependente;
        this.nome_dependente = nome_dependente;
        this.id_plano = id_plano;
        this.valor_plano = valor_plano;
        this.nome_plano = nome_plano;
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

    public Long getId_dependente() {
        return id_dependente;
    }

    public void setId_dependente(Long id_dependente) {
        this.id_dependente = id_dependente;
    }

    public String getNome_dependente() {
        return nome_dependente;
    }

    public void setNome_dependente(String nome_dependente) {
        this.nome_dependente = nome_dependente;
    }

    public Long getId_plano() {
        return id_plano;
    }

    public void setId_plano(Long id_plano) {
        this.id_plano = id_plano;
    }

    public Double getValor_plano() {
        return valor_plano;
    }

    public void setValor_plano(Double valor_plano) {
        this.valor_plano = valor_plano;
    }

    public String getNome_plano() {
        return nome_plano;
    }

    public void setNome_plano(String nome_plano) {
        this.nome_plano = nome_plano;
    }
}
