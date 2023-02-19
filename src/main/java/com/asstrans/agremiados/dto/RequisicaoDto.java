package com.asstrans.agremiados.dto;

import java.math.BigDecimal;

public class RequisicaoDto {
    private Long associadoId;
    private Long convenioId;
    private Long quantidadeParcelas;

    private BigDecimal valorTotal;
    public Long getAssociadoId() {
        return associadoId;
    }

    public void setAssociadoId(Long associadoId) {
        this.associadoId = associadoId;
    }

    public Long getConvenioId() {
        return convenioId;
    }

    public void setConvenioId(Long convenioId) {
        this.convenioId = convenioId;
    }

    public Long getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(Long quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
