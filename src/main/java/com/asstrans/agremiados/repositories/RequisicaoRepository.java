package com.asstrans.agremiados.repositories;

import com.asstrans.agremiados.dto.RequisicaoConvenioTotal;
import com.asstrans.agremiados.dto.RequisicaoMesAssociado;
import com.asstrans.agremiados.dto.RequisicaoTotal;
import com.asstrans.agremiados.model.Requisicao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequisicaoRepository extends JpaRepository<Requisicao, Long> {

    @Query("SELECT req from Requisicao req where req.status = 'ABERTO' and req.associado.id = ?1")
    List<Requisicao> findRequisicoesByAssociado(Long idAssociado);

    @Query("SELECT req from Requisicao req where req.associado.id = ?1 and req.convenio.id = ?2")
    Page<Requisicao> findAllByAssociadoAndConvenio(Long idAssociado, Long idConvenio, Pageable pageable);

    @Query("SELECT req from Requisicao req where req.associado.id = ?1")
    Page<Requisicao> findAllByAssociado(Long idAssociado, Pageable pageable);

    @Query("SELECT req from Requisicao req where req.convenio.id = ?1")
    Page<Requisicao> findAllByConvenio(Long idConvenio, Pageable pageable);

    //REPORT UNIFICADA
    @Query("SELECT req FROM Requisicao req WHERE DATE_PART('MONTH', req.dataRequisicao) = ?1 and DATE_PART('YEAR', req.dataRequisicao) = ?2 order by req.associado.id")
    List<Requisicao> reportUnificada(int mes, int ano);
    @Query(name = "RequisicaoSumTotal" , nativeQuery = true )
    List<RequisicaoTotal> reportUnificadaTotal(int mes, int ano);

    //REPORT NORMAL
    @Query("SELECT req FROM Requisicao req WHERE DATE_PART('MONTH', req.dataRequisicao) = ?1 and DATE_PART('YEAR', req.dataRequisicao) = ?2 order by req.convenio.id")
    List<Requisicao> reportNormal(int mes, int ano);

    @Query(name = "RequisicaoConvenioSumTotal" , nativeQuery = true )
    List<RequisicaoConvenioTotal> reportNormalTotal(int mes, int ano);


    //CONSOLIDADA
    @Query(name = "RequisicaoMesAssociados" , nativeQuery = true )
    List<RequisicaoMesAssociado> reportConsolidadaMesAssociado(int mes, int ano);



}
