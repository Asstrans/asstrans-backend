package com.asstrans.agremiados.model;

import com.asstrans.agremiados.enums.StatusRequisicao;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_REQUISICOES")
public class Requisicao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal valorTotal;

    private BigDecimal valorParcela;

    @Enumerated(EnumType.STRING)
    private StatusRequisicao status;


    @ManyToOne(optional = false,  fetch = FetchType.EAGER)
    private Associado associado;


    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Convenio convenio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(BigDecimal valorParcela) {
        this.valorParcela = valorParcela;
    }

    public StatusRequisicao getStatus() {
        return status;
    }

    public void setStatus(StatusRequisicao status) {
        this.status = status;
    }

}
