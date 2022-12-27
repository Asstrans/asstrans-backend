package com.asstrans.agremiados.services.impl;

import com.asstrans.agremiados.dto.ConvenioDto;
import com.asstrans.agremiados.mapper.ConvenioMapper;
import com.asstrans.agremiados.model.Convenio;
import com.asstrans.agremiados.repositories.ConvenioRepository;
import com.asstrans.agremiados.services.ConvenioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConvenioServiceImpl implements ConvenioService {

    @Autowired
    private ConvenioMapper convenioMapper;

    @Autowired
    private ConvenioRepository convenioRepository;

    @Transactional(readOnly = true)
    public Page<Convenio> findAll(Specification<Convenio> spec, Pageable pageable){
        return convenioRepository.findAll(spec, pageable);
    }

    @Transactional(readOnly = true)
    public Page<Convenio> findActiveAll(Specification<Convenio> spec, Pageable pageable){
        return convenioRepository.findActiveAll(spec, pageable);
    }



    @Override
    public Convenio findById(Long id) {
        return convenioRepository.findById(id).get();
    }

    @Transactional()
    public ConvenioDto save(ConvenioDto convenioDto){
        var convenio = convenioMapper.toConvenio(convenioDto);
        return convenioMapper.toConvenioDto(convenioRepository.save(convenio));
    }

    @Transactional()
    @Override
    public ConvenioDto update(Long id, ConvenioDto convenioDto) {
        Convenio convenio = convenioRepository.getReferenceById(id);
        convenioDto.setId(convenio.getId());

        convenio = convenioMapper.toConvenio(convenioDto);

        return convenioMapper.toConvenioDto(convenioRepository.save(convenio));
    }

    @Transactional()
    @Override
    public void delete(Long id) {
        Convenio convenio = convenioRepository.getReferenceById(id);
        convenio.setActive(false);
        convenioRepository.save(convenio);
    }
}
