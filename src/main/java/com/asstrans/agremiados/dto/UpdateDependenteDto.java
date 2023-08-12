package com.asstrans.agremiados.dto;

import java.util.Date;

public class UpdateDependenteDto {

    private Long id;
    private String nome;

    private String grauParentesco;

    private Date dataNascimento;

    public UpdateDependenteDto() {}

    public UpdateDependenteDto(Long id, String nome, String grauParentesco, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.grauParentesco = grauParentesco;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
