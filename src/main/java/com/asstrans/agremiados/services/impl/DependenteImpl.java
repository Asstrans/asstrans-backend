package com.asstrans.agremiados.services.impl;

import com.asstrans.agremiados.model.Dependente;
import com.asstrans.agremiados.repositories.DependenteRepository;
import com.asstrans.agremiados.services.DependenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DependenteImpl implements DependenteService {

    @Autowired
    private DependenteRepository dependenteRepository;

    @Override
    public Dependente save(Dependente dependente) {
        return dependenteRepository.save(dependente);
    }

    @Override
    public List<Dependente> findAll() {
        return dependenteRepository.findAll();
    }
}
