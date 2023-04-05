package com.asstrans.agremiados.services;

import com.asstrans.agremiados.dto.PlanoDto;
import com.asstrans.agremiados.dto.UpdatePlanoDto;
import com.asstrans.agremiados.model.Plano;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlanoService {

    public void delete(Long id);
    public Plano update(Long id, UpdatePlanoDto updatePlanoDto);
    public Plano save(PlanoDto planoDto);
    public Plano findById(Long id);
    public List<Plano> findAll();
    public Page<Plano> findAll(Pageable pageable);
    public Page<Plano> findAllIgnoreCase(String search, Pageable pageable);


}
