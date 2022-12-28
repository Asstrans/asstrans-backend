package com.asstrans.agremiados.repositories;

import com.asstrans.agremiados.model.Convenio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvenioRepository extends JpaRepository<Convenio, Long>, JpaSpecificationExecutor<Convenio> {

   // @Query(value = "SELECT * FROM TB_CONVENIOS WHERE IS_ACTIVE = true", nativeQuery = true)
    @Query(value = "select c from Convenio c where c.isActive = true")
    public Page<Convenio> findActiveAll(Specification<Convenio> spec, Pageable pageable);

    @Query(value = "select c from Convenio c where c.isActive = true and c.fantasyName like %?1% ")
    public Page<Convenio> findAllSearch(String search, Pageable pageable);
}
