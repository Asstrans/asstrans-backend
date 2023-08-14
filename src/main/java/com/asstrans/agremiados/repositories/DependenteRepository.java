package com.asstrans.agremiados.repositories;

import com.asstrans.agremiados.model.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Long> {

    @Query(value = "select d from Dependente d where d.associado.id = ?1 ")
    public List<Dependente> findAllDependentesByAssociado(Long idAssociado);


}
