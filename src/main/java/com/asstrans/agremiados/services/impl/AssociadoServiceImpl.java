package com.asstrans.agremiados.services.impl;


import com.asstrans.agremiados.dto.AssociadoDto;
import com.asstrans.agremiados.mapper.AssociadoMapper;
import com.asstrans.agremiados.model.Associado;

import com.asstrans.agremiados.model.Convenio;
import com.asstrans.agremiados.model.Dependente;
import com.asstrans.agremiados.model.Requisicao;
import com.asstrans.agremiados.repositories.AssociadoRepository;
import com.asstrans.agremiados.repositories.DependenteRepository;
import com.asstrans.agremiados.repositories.RequisicaoRepository;
import com.asstrans.agremiados.services.AssociadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.List;

@Service
public class AssociadoServiceImpl implements AssociadoService {

    @Autowired
    private RequisicaoRepository requisicaoRepository;

    @Autowired
    private AssociadoRepository associadoRepository;

    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
    private AssociadoMapper associadoMapper;


    @Override
    public Page<Associado> findAll(Specification<Associado> spec, Pageable pageable) {
        return associadoRepository.findAll(spec, pageable);
    }

    @Override
    public Page<Associado> findAllSearch(String search, Pageable pageable) {
        return associadoRepository.findAllSearch(search, pageable);
    }


    @Transactional(readOnly = true)
    public Page<Associado> findActiveAll(Specification<Associado> spec, Pageable pageable){
        return associadoRepository.findActiveAll(spec, pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Associado findById(Long id) {
        return associadoRepository.findById(id).get();
    }


    @Transactional()
    @Override
    public Associado save(Associado associado) {
        MathContext m = new MathContext(1);
        associado.setLimiteUtilizado(new BigDecimal(0));
        associado.setLimiteTotal(associado.getSalarioBase()
                .multiply(new BigDecimal(0.3)).setScale(2, RoundingMode.HALF_UP));
        return associadoRepository.save(associado);
    }

    @Transactional()
    @Override
    public Associado saveDependente(Long idAssociado, Dependente dependente) {
        Associado associado = associadoRepository.findById(idAssociado).get();
        dependente.setCreatedAt(Instant.now());
        dependente.setAssociado(associado);
        dependenteRepository.save(dependente);
        //associado.getDependentes().add(dependente);
        return  associado;
    }

    private BigDecimal getValorParcelaRequisicoes(List<Requisicao> requisicoes){
        var valor = new BigDecimal(0);
        for (Requisicao requisicao: requisicoes) {
            valor = valor.add(requisicao.getValorParcela());
        }
        return valor;
    }

    @Transactional()
    @Override
    public AssociadoDto update(Long id, AssociadoDto associadoDto) {
        Associado associado = associadoRepository.getReferenceById(id);
        final var requisicoes = requisicaoRepository.findRequisicoesByAssociado(associado.getId());
        final var total = getValorParcelaRequisicoes(requisicoes);

        associadoDto.setId(associado.getId());
        associado = associadoMapper.toAssociado(associadoDto);
        associado.setLimiteTotal(associado.getSalarioBase()
                .multiply(new BigDecimal(0.3)).setScale(2, RoundingMode.HALF_UP));
        associado.setLimiteUtilizado(associado.getLimiteUtilizado().add(total));
        return associadoMapper.toAssociadoDto(associadoRepository.save(associado));
    }

    @Transactional()
    @Override
    public void delete(Long id) {
        Associado associado = associadoRepository.getReferenceById(id);
        associado.setActive(false);
        associadoRepository.save(associado);
    }

    @Override
    public long count() {
        return associadoRepository.count();
    }
}
