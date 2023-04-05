package com.asstrans.agremiados.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_ROLES")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String autority;

    public Long getId() {
        return id;
    }

    public Role() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutority() {
        return autority;
    }

    public void setAutority(String autority) {
        this.autority = autority;
    }
}
