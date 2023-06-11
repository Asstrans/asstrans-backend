package com.asstrans.agremiados.services;

import com.asstrans.agremiados.dto.RequisicaoConvenioTotal;
import com.asstrans.agremiados.dto.RequisicaoDto;
import com.asstrans.agremiados.dto.RequisicaoTotal;
import com.asstrans.agremiados.model.Parcela;
import com.asstrans.agremiados.model.Requisicao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RequisicaoService {
    public Requisicao save(RequisicaoDto requisicaoDto);

    public void delete(Long id);
    public Requisicao findById(Long id);
    public void aceitar(Long id);
    public void reprovar(Long id);
    public void darBaixaParcela(Long idRequisicao, Long idParcela);
    List<Parcela> findAllParcelasPagasByRequisicao(Long id);
    List<Parcela> findAllParcelasByRequisicao(Long id);
    Page<Requisicao> findAllByAssociadoAndConvenio(Long idAssociado, Long idConvenio, Pageable pageable);
    Page<Requisicao> findAllByAssociado(Long idAssociado, Pageable pageable);
    Page<Requisicao> findAllByConvenio(Long idConvenio, Pageable pageable);

    Page<Requisicao> findAll(Pageable pageable);

    //REPORT
    public List<Requisicao> reportUnificada(int mes);
    public List<RequisicaoTotal> reportUnificadaTotal(int mes);

    //NORMAL
    public List<Requisicao> reportNormal(int mes);

    public List<RequisicaoConvenioTotal> reportNormalTotal(int mes);


}
