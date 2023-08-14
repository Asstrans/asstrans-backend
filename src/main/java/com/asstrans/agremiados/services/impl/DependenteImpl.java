package com.asstrans.agremiados.services.impl;

import com.asstrans.agremiados.dto.UpdateDependenteDto;
import com.asstrans.agremiados.mapper.DependenteMapper;
import com.asstrans.agremiados.model.Dependente;
import com.asstrans.agremiados.repositories.DependenteRepository;
import com.asstrans.agremiados.services.DependenteService;
import com.asstrans.agremiados.services.PlanoAssociadoDependenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class DependenteImpl implements DependenteService {

    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
    private PlanoAssociadoDependenteService planoAssociadoDependenteService;

    @Autowired
    private DependenteMapper dependenteMapper;

    @Override
    public Dependente save(Dependente dependente) {
        return dependenteRepository.save(dependente);
    }


    @Transactional()
    @Override
    public void delete(Long id) {
        dependenteRepository.deleteById(id);
    }

    @Override
    public UpdateDependenteDto updateDependente(Long id, UpdateDependenteDto updateDependenteDto) {
//        System.out.println("UpdateDependenteDto");
//        Dependente dependente = dependenteRepository.getReferenceById(id);
//        System.out.println(dependente);
//        updateDependenteDto.setId(dependente.getId());
//        dependente = dependenteMapper.toDependente(updateDependenteDto);
        Dependente dependente = dependenteRepository.findById(id).get();
        dependente.setDataNascimento(updateDependenteDto.getDataNascimento());
        dependente.setNome(updateDependenteDto.getNome());
        dependente.setGrauParentesco(updateDependenteDto.getGrauParentesco());
        return dependenteMapper.toDependenteDto(dependenteRepository.save(dependente));
    }

    @Override
    public List<Dependente> findByAssociado(Long id) {
        return dependenteRepository.findAllDependentesByAssociado(id);
    }

    @Override
    public List<Dependente> findAll() {
        return dependenteRepository.findAll();
    }
}
