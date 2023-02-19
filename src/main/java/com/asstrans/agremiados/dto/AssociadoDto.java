package com.asstrans.agremiados.dto;

import com.asstrans.agremiados.enums.ZoneCity;

import java.math.BigDecimal;

public class AssociadoDto {

    private Long id;
    private String matricula;

    private String name;

    private String email;

    private ZoneCity zoneCity;

    private String rg;

    private String cpf;

    private String setor;

    private String celular;

    private BigDecimal salarioBase;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public BigDecimal getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(BigDecimal salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ZoneCity getZoneCity() {
        return zoneCity;
    }

    public void setZoneCity(ZoneCity zoneCity) {
        this.zoneCity = zoneCity;
    }
}
