package com.asstrans.agremiados.repositories;

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

}
