package com.asstrans.agremiados.model;

import com.asstrans.agremiados.enums.StatusParcela;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TB_PARCELAS")
public class Parcela implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private StatusParcela status;

    @Temporal(TemporalType.DATE)
    private Date dataVencimento;

    @ManyToOne
    @JoinColumn(name = "requisicao_id")
    private Requisicao requisicao;

    public Parcela() {

    }

    public Parcela(Long id,
                   String name,
                   BigDecimal valor,
                   StatusParcela status,
                   Date dataVencimento,
                   Requisicao requisicao
    ) {
        this.id = id;
        this.name = name;
        this.valor = valor;
        this.status = status;
        this.dataVencimento = dataVencimento;
        this.requisicao = requisicao;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Requisicao getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(Requisicao requisicao) {
        this.requisicao = requisicao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusParcela getStatus() {
        return status;
    }

    public void setStatus(StatusParcela status) {
        this.status = status;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
