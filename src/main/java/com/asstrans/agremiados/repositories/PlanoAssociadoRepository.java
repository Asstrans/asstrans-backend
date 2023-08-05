package com.asstrans.agremiados.repositories;

import com.asstrans.agremiados.dto.PlanoAssociadoAll;
import com.asstrans.agremiados.dto.RequisicaoMesAssociado;
import com.asstrans.agremiados.model.PlanoAssociado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanoAssociadoRepository extends JpaRepository<PlanoAssociado, Long> {

    @Query(value = "select pa from PlanoAssociado pa where pa.associado.id = ?1 and pa.plano.id = ?2")
    public PlanoAssociado findPlanoAssociado(Long idAssociado, Long idPlano);

    @Query(value = "select pa from PlanoAssociado pa")
    public PlanoAssociado findPlanoAssociadoAll();


    //CONSOLIDADA
    @Query(name = "PlanoAssociadosAll" , nativeQuery = true )
    List<PlanoAssociadoAll> reportPlanosAssociadosAll();

}
