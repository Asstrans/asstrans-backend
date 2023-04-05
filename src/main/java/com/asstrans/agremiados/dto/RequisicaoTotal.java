package com.asstrans.agremiados.dto;

public class RequisicaoTotal {

    private Long associado_id;
    private double total;

    public RequisicaoTotal(){}

    public RequisicaoTotal(Long associado_id, double total) {
        this.associado_id = associado_id;
        this.total = total;
    }


    public Long getAssociado_id() {
        return associado_id;
    }

    public void setAssociado_id(Long associado_id) {
        this.associado_id = associado_id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
