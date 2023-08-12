package com.asstrans.agremiados.services;

import com.asstrans.agremiados.dto.UpdateDependenteDto;
import com.asstrans.agremiados.model.Dependente;

import java.util.List;
import java.util.Set;

public interface DependenteService {

    public Dependente save(Dependente dependente);

    public void delete(Long id);

    public UpdateDependenteDto update(Long id, UpdateDependenteDto updateDependenteDto);

    public List<Dependente> findAll();
}
