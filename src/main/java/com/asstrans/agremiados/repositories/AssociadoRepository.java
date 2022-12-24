package com.asstrans.agremiados.repositories;

import com.asstrans.agremiados.model.Associado;
import com.asstrans.agremiados.model.Convenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long>, JpaSpecificationExecutor<Associado> {
}
