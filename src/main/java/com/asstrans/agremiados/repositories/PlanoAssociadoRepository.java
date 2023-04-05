package com.asstrans.agremiados.repositories;

import com.asstrans.agremiados.model.PlanoAssociado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoAssociadoRepository extends JpaRepository<PlanoAssociado, Long> {

    @Query(value = "select pa from PlanoAssociado pa where pa.associado.id = ?1 and pa.plano.id = ?2")
    public PlanoAssociado findPlanoAssociado(Long idAssociado, Long idPlano);
}
