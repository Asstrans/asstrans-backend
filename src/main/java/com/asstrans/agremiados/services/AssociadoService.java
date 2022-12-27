package com.asstrans.agremiados.services;

import com.asstrans.agremiados.dto.AssociadoDto;
import com.asstrans.agremiados.model.Associado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface AssociadoService {

    public Page<Associado> findAll(Specification<Associado> spec, Pageable pageable);

    public Page<Associado> findActiveAll(Specification<Associado> spec, Pageable pageable);

    public Associado findById(Long id);

    public Associado save(Associado associado);

    public AssociadoDto update(Long id, AssociadoDto associadoDto);

    public void delete(Long id);

}
