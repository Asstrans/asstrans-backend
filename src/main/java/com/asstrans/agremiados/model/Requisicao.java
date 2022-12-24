package com.asstrans.agremiados.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_REQUISICOES")
public class Requisicao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
