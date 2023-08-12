package com.asstrans.agremiados.services;

import com.asstrans.agremiados.dto.PlanoAssociadoDependenteDto;
import com.asstrans.agremiados.model.PlanoAssociadoDependente;

public interface PlanoAssociadoDependenteService {
    PlanoAssociadoDependente save(PlanoAssociadoDependenteDto planoAssociadoDependenteDto);
    PlanoAssociadoDependente verifyPlanoAssociadoDependente(Long idPlanoAssociado, Long idDependente);

    void deleteDependente(Long id);
    public void delete(Long id);
}
