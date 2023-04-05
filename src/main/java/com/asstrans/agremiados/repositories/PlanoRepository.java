package com.asstrans.agremiados.repositories;

import com.asstrans.agremiados.model.Plano;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {

    @Query(value = "SELECT * FROM TB_PLANOS WHERE IS_ACTIVE = true", nativeQuery = true)
    public Page<Plano> findActiveAll(Pageable pageable);

    @Query(value = "select p from Plano p where p.isActive = true and (p.nome like %?1%)")
    public Page<Plano> findAllSearchIgnoreCase(String search, Pageable pageable);
}
