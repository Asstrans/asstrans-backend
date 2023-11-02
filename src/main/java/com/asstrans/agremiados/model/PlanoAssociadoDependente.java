package com.asstrans.agremiados.model;

import com.asstrans.agremiados.dto.PlanoAssociadoAll;
import com.asstrans.agremiados.dto.PlanoAssociadoDependenteAll;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@NamedNativeQuery(
        name = "PlanoAssociadosDependentesAll",
        query = "SELECT " +
                " ASS.ID as id_associado, " +
                " ASS.NAME as nome_associado, " +
                " DEP.ID as id_dependente, " +
                " DEP.NOME as nome_dependente, " +
                " PL.ID as id_plano, " +
                " PL.VALOR as valor_plano, " +
                " PL.NOME as nome_plano " +
                " FROM TB_PLANOS_ASSOCIADOS_DEPENDENTES as PLA_ASS_DEP " +
                " INNER JOIN TB_DEPENDENTES as DEP ON  PLA_ASS_DEP.DEPENDENTE_ID = DEP.ID " +
                " INNER JOIN TB_PLANOS_ASSOCIADOS as PL_ASS ON PLA_ASS_DEP.PLANO_ASSOCIADO_ID = PL_ASS.ID " +
                " INNER JOIN TB_PLANOS as PL ON PL_ASS.PLANO_ID = PL.ID " +
                " INNER JOIN TB_ASSOCIADOS as ASS ON PL_ASS.ASSOCIADO_ID = ASS.ID",
        resultSetMapping = "PlanoAssociadosDependentesAllResult"
)
@SqlResultSetMapping(
        name = "PlanoAssociadosDependentesAllResult",
        classes = @ConstructorResult(
                targetClass = PlanoAssociadoDependenteAll.class,
                columns = {
                        @ColumnResult(name = "id_associado", type = Long.class),
                        @ColumnResult(name = "nome_associado", type = String.class),
                        @ColumnResult(name = "id_dependente", type = Long.class),
                        @ColumnResult(name = "nome_dependente", type = String.class),
                        @ColumnResult(name = "id_plano", type = Long.class),
                        @ColumnResult(name = "valor_plano", type = Double.class),
                        @ColumnResult(name = "nome_plano", type = String.class),
                }))
@Table(name = "TB_PLANOS_ASSOCIADOS_DEPENDENTES")
public class PlanoAssociadoDependente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plano_associado_id")
    private PlanoAssociado planoAssociado;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "dependente_id")
    private Dependente dependente;

    private Instant createdAt;


    public PlanoAssociadoDependente() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public PlanoAssociado getPlanoAssociado() {
        return planoAssociado;
    }

    public void setPlanoAssociado(PlanoAssociado planoAssociado) {
        this.planoAssociado = planoAssociado;
    }

    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
