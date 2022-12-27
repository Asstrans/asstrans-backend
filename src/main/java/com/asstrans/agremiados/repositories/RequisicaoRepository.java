package com.asstrans.agremiados.repositories;

import com.asstrans.agremiados.model.Requisicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisicaoRepository extends JpaRepository<Requisicao, Long> {
}
