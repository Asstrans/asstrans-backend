package com.asstrans.agremiados.repositories;

import com.asstrans.agremiados.model.Parcela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParcelaRepository extends JpaRepository<Parcela, Long> {

    @Query(value = "select p from Parcela p where p.status = 'PAGO' and p.requisicao.id = ?1 ")
    public List<Parcela> findAllParcelasPagasByRequisicao(Long idRequisicao);

    @Query(value = "select p from Parcela p where p.requisicao.id = ?1 ")
    public List<Parcela> findAllParcelasByRequisicao(Long idRequisicao);


}
