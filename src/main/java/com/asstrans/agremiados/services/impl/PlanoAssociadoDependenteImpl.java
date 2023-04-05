package com.asstrans.agremiados.services.impl;

import com.asstrans.agremiados.dto.PlanoAssociadoDependenteDto;
import com.asstrans.agremiados.model.PlanoAssociado;
import com.asstrans.agremiados.model.PlanoAssociadoDependente;
import com.asstrans.agremiados.repositories.*;
import com.asstrans.agremiados.services.PlanoAssociadoDependenteService;
import com.asstrans.agremiados.services.PlanoAssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class PlanoAssociadoDependenteImpl implements PlanoAssociadoDependenteService {

    @Autowired
    private PlanoAssociadoDependenteRepository planoAssociadoDependenteRepository;

    @Autowired
    private PlanoAssociadoRepository planoAssociadoRepository;

    @Autowired
    private DependenteRepository dependenteRepository;

    @Override
    public void delete(Long id) {
        this.planoAssociadoDependenteRepository.deleteById(id);
    }

    @Transactional()
    @Override
    public PlanoAssociadoDependente save(PlanoAssociadoDependenteDto planoAssociadoDependenteDto) {
        var planoAssociado = planoAssociadoRepository.findById(planoAssociadoDependenteDto.idPlanoAssociado());
        var dependente = dependenteRepository.findById(planoAssociadoDependenteDto.idDependente());
        var planoAssociadoDependente = new PlanoAssociadoDependente();
        planoAssociadoDependente.setPlanoAssociado(planoAssociado.get());
        planoAssociadoDependente.setDependente(dependente.get());
        planoAssociadoDependente.setCreatedAt(Instant.now());
        return planoAssociadoDependenteRepository.save(planoAssociadoDependente);
    }

    @Override
    public PlanoAssociadoDependente verifyPlanoAssociadoDependente(Long idPlanoAssociado, Long idDependente) {
        return this.planoAssociadoDependenteRepository.verifyPlanoAssociadoDependente(idPlanoAssociado, idDependente);
    }
}
