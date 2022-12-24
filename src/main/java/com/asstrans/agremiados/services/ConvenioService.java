package com.asstrans.agremiados.services;

import com.asstrans.agremiados.dto.ConvenioDto;
import com.asstrans.agremiados.model.Convenio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface ConvenioService {
    public Page<Convenio> findAll(Specification<Convenio> spec, Pageable pageable);
    public ConvenioDto save(ConvenioDto convenioDto);
    public ConvenioDto update(Long id, ConvenioDto conveniodto);

    public void delete(Long id);

}
