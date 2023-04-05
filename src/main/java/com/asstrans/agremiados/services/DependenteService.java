package com.asstrans.agremiados.services;

import com.asstrans.agremiados.model.Dependente;

import java.util.List;
import java.util.Set;

public interface DependenteService {

    public Dependente save(Dependente dependente);

    public List<Dependente> findAll();
}
