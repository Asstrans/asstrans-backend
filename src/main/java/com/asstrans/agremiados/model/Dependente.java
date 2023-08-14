package com.asstrans.agremiados.model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "TB_DEPENDENTES")
public class Dependente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String grauParentesco;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;


    private Instant createdAt;

    @ManyToOne
    @JoinColumn(name = "associado_id")
    private Associado associado;



    public Dependente() {

    }

    public Dependente(Long id, String nome, String grauParentesco, Date dataNascimento, Instant createdAt, Associado associado) {
        this.id = id;
        this.nome = nome;
        this.grauParentesco = grauParentesco;
        this.dataNascimento = dataNascimento;
        this.createdAt = createdAt;
        this.associado = associado;
    }

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}