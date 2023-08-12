package com.asstrans.agremiados.repositories;

import com.asstrans.agremiados.model.PlanoAssociadoDependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoAssociadoDependenteRepository extends JpaRepository<PlanoAssociadoDependente, Long> {

    @Query(value = "select pad from PlanoAssociadoDependente pad where pad.planoAssociado.id = ?1 and pad.dependente.id = ?2")
    public PlanoAssociadoDependente verifyPlanoAssociadoDependente(Long idPlanoAssociado, Long idDependente);
    @Query(value = "select pad from PlanoAssociadoDependente pad where pad.dependente.id = ?1")
    public PlanoAssociadoDependente verifyPlanoAssociadoDependenteById(Long idDependente);
}
