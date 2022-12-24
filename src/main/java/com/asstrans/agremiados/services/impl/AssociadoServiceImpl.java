package com.asstrans.agremiados.services.impl;


import com.asstrans.agremiados.dto.AssociadoDto;
import com.asstrans.agremiados.mapper.AssociadoMapper;
import com.asstrans.agremiados.model.Associado;
import com.asstrans.agremiados.repositories.AssociadoRepository;
import com.asstrans.agremiados.services.AssociadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AssociadoServiceImpl implements AssociadoService {

    @Autowired
    private AssociadoRepository associadoRepository;

    @Autowired
    private AssociadoMapper associadoMapper;


    @Override
    public Page<Associado> findAll(Specification<Associado> spec, Pageable pageable) {
        return associadoRepository.findAll(spec, pageable);
    }

    @Transactional()
    @Override
    public Associado save(Associado associado) {
        return associadoRepository.save(associado);
    }

    @Transactional()
    @Override
    public AssociadoDto update(Long id, AssociadoDto associadoDto) {
        Associado associado = associadoRepository.getReferenceById(id);
        associadoDto.setId(associado.getId());
        associado = associadoMapper.toAssociado(associadoDto);
        return associadoMapper.toAssociadoDto(associadoRepository.save(associado));
    }

    @Transactional()
    @Override
    public void delete(Long id) {
        Associado associado = associadoRepository.getReferenceById(id);
        associado.setActive(false);
        associadoRepository.save(associado);
    }
}
