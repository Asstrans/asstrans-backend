package com.asstrans.agremiados.repositories;

import com.asstrans.agremiados.model.Convenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvenioRepository extends JpaRepository<Convenio, Long>, JpaSpecificationExecutor<Convenio> {
}
