package com.asstrans.agremiados.repositories;

import com.asstrans.agremiados.model.Associado;
import com.asstrans.agremiados.model.Convenio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long>, JpaSpecificationExecutor<Associado> {

    @Query(value = "SELECT * FROM TB_ASSOCIADOS WHERE IS_ACTIVE = true", nativeQuery = true)
    public Page<Associado> findActiveAll(Specification<Associado> spec, Pageable pageable);

    @Query(value = "select a from Associado a where a.isActive = true and (a.matricula like %?1% or a.name like %?1%)")
    public Page<Associado> findAllSearch(String search, Pageable pageable);
}
