package com.asstrans.agremiados.services.impl;

import com.asstrans.agremiados.dto.PlanoAssociadoDto;
import com.asstrans.agremiados.model.PlanoAssociado;
import com.asstrans.agremiados.repositories.AssociadoRepository;
import com.asstrans.agremiados.repositories.PlanoAssociadoRepository;
import com.asstrans.agremiados.repositories.PlanoRepository;
import com.asstrans.agremiados.services.PlanoAssociadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class PlanoAssociadoImpl implements PlanoAssociadoService {

    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private AssociadoRepository associadoRepository;

    @Autowired
    private PlanoAssociadoRepository planoAssociadoRepository;

    @Override
    public void delete(Long id) {
        this.planoAssociadoRepository.deleteById(id);
    }

    @Override
    @Transactional()
    public PlanoAssociado save(PlanoAssociadoDto planoAssociadoDto) {
        var plano = planoRepository.findById(planoAssociadoDto.idPlano()).get();
        var associado = associadoRepository.findById(planoAssociadoDto.idAssociado()).get();
        var planoAssociado = new PlanoAssociado();
        planoAssociado.setAssociado(associado);
        planoAssociado.setCreatedAt(Instant.now());
        planoAssociado.setPlano(plano);
        return planoAssociadoRepository.save(planoAssociado);
    }

    @Override
    public List<PlanoAssociado> findAll() {
        return planoAssociadoRepository.findAll();
    }

    @Override
    public PlanoAssociado findPlanoAssociado(Long idAssociado, Long idPlano) {
        var planoAssociado = planoAssociadoRepository.findPlanoAssociado(idAssociado, idPlano);
        return  planoAssociado;
    }
}
