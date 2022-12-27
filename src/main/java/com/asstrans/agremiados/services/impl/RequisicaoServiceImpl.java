package com.asstrans.agremiados.services.impl;

import com.asstrans.agremiados.dto.RequisicaoDto;
import com.asstrans.agremiados.model.Requisicao;
import com.asstrans.agremiados.repositories.AssociadoRepository;
import com.asstrans.agremiados.repositories.ConvenioRepository;
import com.asstrans.agremiados.repositories.RequisicaoRepository;
import com.asstrans.agremiados.services.RequisicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequisicaoServiceImpl implements RequisicaoService {

    @Autowired
    private RequisicaoRepository requisicaoRepository;

    @Autowired
    private AssociadoRepository associadoRepository;

    @Autowired
    private ConvenioRepository convenioRepository;


    @Override
    public Requisicao save(RequisicaoDto requisicaoDto) {
        var associado = associadoRepository.findById(requisicaoDto.getAssociadoId());
        var convenio = convenioRepository.findById(requisicaoDto.getConvenioId());
        var requisicao = new Requisicao();
        requisicao.setAssociado(associado.get());
        requisicao.setConvenio(convenio.get());
        return  requisicaoRepository.save(requisicao);
    }
}
