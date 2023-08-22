package com.asstrans.agremiados.services;

import com.asstrans.agremiados.dto.PlanoAssociadoDto;
import com.asstrans.agremiados.model.PlanoAssociado;

import java.util.List;

public interface PlanoAssociadoService {

    void delete(Long id);
    PlanoAssociado save(PlanoAssociadoDto planoAssociadoDto);
    List<PlanoAssociado> findAll();

    List<PlanoAssociado> findAllByAssociado(Long idAssociado);

    PlanoAssociado findPlanoAssociado(Long idAssociado, Long idPlano);
}
