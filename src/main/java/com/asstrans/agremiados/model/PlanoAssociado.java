package com.asstrans.agremiados.model;

import com.asstrans.agremiados.dto.PlanoAssociadoAll;
import com.asstrans.agremiados.dto.RequisicaoMesAssociado;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
//CONSOLIDADA
@NamedNativeQuery(
        name = "PlanoAssociadosAll",
        query = "SELECT " +
                " PL.ID as id_plano, " +
                " PL.CORPORATE_NAME as razao_social, " +
                " PL.VALOR as valor_plano, " +
                " PL.NOME as nome_plano, " +
                " ASS.ID as id_associado, " +
                " ASS.NAME as nome_associado " +
                " FROM TB_PLANOS_ASSOCIADOS as PLA " +
                " INNER JOIN TB_ASSOCIADOS as ASS ON PLA.ASSOCIADO_ID = ASS.ID " +
                " INNER JOIN TB_PLANOS as PL ON PL.ID = PLA.PLANO_ID",
        resultSetMapping = "PlanoAssociadosAllResult"
)
@SqlResultSetMapping(
        name = "PlanoAssociadosAllResult",
        classes = @ConstructorResult(
                targetClass = PlanoAssociadoAll.class,
                columns = {
                        @ColumnResult(name = "id_plano", type = Long.class),
                        @ColumnResult(name = "razao_social", type = String.class),
                        @ColumnResult(name = "valor_plano", type = Double.class),
                        @ColumnResult(name = "nome_plano", type = String.class),
                        @ColumnResult(name = "id_associado", type = Long.class),
                        @ColumnResult(name = "nome_associado", type = String.class),
                }))
@Table(name = "TB_PLANOS_ASSOCIADOS")
public class PlanoAssociado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "associado_id")
    private Associado associado;

    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano plano;


    private Instant createdAt;


    public PlanoAssociado() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }


    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
