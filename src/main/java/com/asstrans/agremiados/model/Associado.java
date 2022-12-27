package com.asstrans.agremiados.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "TB_ASSOCIADOS")
public class Associado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String matricula;

    private String name;

    private String rg;

    private String cpf;

    private String setor;

    private String celular;

    private BigDecimal salarioBase;

    private Boolean isActive;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "associado", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private Set<Requisicao> requisicoes;


    public Associado(){
        this.isActive = true;
    }


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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Set<Requisicao> getRequisicoes() {
        return requisicoes;
    }

    public void setRequisicoes(Set<Requisicao> requisicoes) {
        this.requisicoes = requisicoes;
    }


}
