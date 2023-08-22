package com.asstrans.agremiados.services.impl;

import com.asstrans.agremiados.dto.PlanoDto;
import com.asstrans.agremiados.dto.UpdatePlanoDto;
import com.asstrans.agremiados.mapper.PlanoMapper;
import com.asstrans.agremiados.model.Plano;
import com.asstrans.agremiados.repositories.PlanoRepository;
import com.asstrans.agremiados.services.PlanoService;

import com.asstrans.agremiados.services.exceptions.PlanoIntegrityException;
import org.hibernate.dialect.PostgreSQL9Dialect;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class PlanoServiceImpl implements PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private PlanoMapper planoMapper;

    @Transactional
    @Override
    public void delete(Long id) {
        try {
            var plano = planoRepository.findById(id).get();
            planoRepository.delete(plano);
        }catch (DataIntegrityViolationException e){
//            if (e.getMostSpecificCause().getClass().getName().equals("org.postgresql.util.PSQLException")){
//                throw  new PlanoIntegrityException("Plano possui processos que não podem ser excluídos");
//            }
            throw  new PlanoIntegrityException("Plano possui processos que não podem ser excluídos");
        }

    }

    @Transactional
    @Override
    public Plano update(Long id, UpdatePlanoDto updatePlanoDto) {
        var plano = planoRepository.getReferenceById(id);
        updatePlanoDto.setId(plano.getId());
        updatePlanoDto.setActive(true);
        return planoRepository.save(planoMapper.toPlano(updatePlanoDto));
    }

    @Transactional
    @Override
    public Plano save(PlanoDto planoDto) {
        var plano = planoMapper.toPlano(planoDto);
        plano.setActive(true);
        return planoRepository.save(plano);
    }

    @Override
    public Plano findById(Long id) {
        return null;
    }

    @Override
    public List<Plano> findAll() {
        return planoRepository.findAll();
    }

    @Override
    public Page<Plano> findAll(Pageable pageable) {
        return planoRepository.findAll(pageable);
    }

    @Override
    public Page<Plano> findAllIgnoreCase(String search, Pageable pageable) {
        return planoRepository.findAllSearchIgnoreCase(search, pageable);
    }

    @Override
    public long count() {
        return planoRepository.count();
    }
}
