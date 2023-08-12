package com.asstrans.agremiados.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "TB_PLANOS_ASSOCIADOS_DEPENDENTES")
public class PlanoAssociadoDependente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plano_associado_id")
    private PlanoAssociado planoAssociado;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "dependente_id")
    private Dependente dependente;

    private Instant createdAt;


    public PlanoAssociadoDependente() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public PlanoAssociado getPlanoAssociado() {
        return planoAssociado;
    }

    public void setPlanoAssociado(PlanoAssociado planoAssociado) {
        this.planoAssociado = planoAssociado;
    }

    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
