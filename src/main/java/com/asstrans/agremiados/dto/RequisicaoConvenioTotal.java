package com.asstrans.agremiados.dto;

public class RequisicaoConvenioTotal {
    private Long convenio_id;
    private double total;

    public RequisicaoConvenioTotal(){}

    public RequisicaoConvenioTotal(Long convenio_id, double total) {
        this.convenio_id = convenio_id;
        this.total = total;
    }

    public Long getConvenio_id() {
        return convenio_id;
    }

    public void setConvenio_id(Long convenio_id) {
        this.convenio_id = convenio_id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
