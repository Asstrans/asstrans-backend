package com.asstrans.agremiados.model;

import com.asstrans.agremiados.dto.RequisicaoConvenioTotal;
import com.asstrans.agremiados.dto.RequisicaoMesAssociado;
import com.asstrans.agremiados.dto.RequisicaoTotal;
import com.asstrans.agremiados.enums.StatusRequisicao;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity

//UNIFICADA
@NamedNativeQuery(
        name = "RequisicaoSumTotal",
        query = "SELECT TB_REQUISICOES.ASSOCIADO_ID, SUM(TB_REQUISICOES.VALOR_PARCELA) as total FROM TB_REQUISICOES WHERE DATE_PART('Month',TB_REQUISICOES.DATA_REQUISICAO) = ?1 and DATE_PART('Year',TB_REQUISICOES.DATA_REQUISICAO) = ?2  GROUP BY TB_REQUISICOES.ASSOCIADO_ID",
        resultSetMapping = "RequisicaoTotal"
)
@SqlResultSetMapping(
        name = "RequisicaoTotal",
        classes = @ConstructorResult(
                targetClass = RequisicaoTotal.class,
                columns = {
                        @ColumnResult(name = "associado_id", type = Long.class),
                        @ColumnResult(name = "total", type = Double.class)}))

//NORMAL
@NamedNativeQuery(
        name = "RequisicaoConvenioSumTotal",
        query = "SELECT TB_REQUISICOES.CONVENIO_ID, SUM(TB_REQUISICOES.VALOR_PARCELA) as total FROM TB_REQUISICOES WHERE DATE_PART('Month',TB_REQUISICOES.DATA_REQUISICAO) = ?1 and DATE_PART('Year',TB_REQUISICOES.DATA_REQUISICAO) = ?2  GROUP BY TB_REQUISICOES.CONVENIO_ID",
        resultSetMapping = "RequisicaoConvenioTotal"
)
@SqlResultSetMapping(
        name = "RequisicaoConvenioTotal",
        classes = @ConstructorResult(
                targetClass = RequisicaoConvenioTotal.class,
                columns = {
                        @ColumnResult(name = "convenio_id", type = Long.class),
                        @ColumnResult(name = "total", type = Double.class)}))

//CONSOLIDADA
@NamedNativeQuery(
        name = "RequisicaoMesAssociados",
        query = "SELECT " +
                "R.ID as id_requisicao, " +
                "R.VALOR_TOTAL, " +
                "R.VALOR_PARCELA, " +
                "ASS.ID as id_associado, " +
                "ASS.NAME as nome_associado, " +
                "ASS.SALARIO_BASE as salario_associado, " +
                "CON.ID as id_convenio, " +
                "CON.FANTASY_NAME as nome_convenio " +
                "FROM TB_REQUISICOES as R " +
                "INNER JOIN TB_ASSOCIADOS as ASS ON R.ASSOCIADO_ID = ASS.ID " +
                "INNER JOIN TB_CONVENIOS as CON ON R.CONVENIO_ID = CON.ID " +
                "WHERE DATE_PART('Month',R.DATA_REQUISICAO) = ?1 AND " +
                "DATE_PART('Year',R.DATA_REQUISICAO) = ?2",
        resultSetMapping = "RequisicaoMesResult"
)
@SqlResultSetMapping(
        name = "RequisicaoMesResult",
        classes = @ConstructorResult(
                targetClass = RequisicaoMesAssociado.class,
                columns = {
                        @ColumnResult(name = "id_requisicao", type = Long.class),
                        @ColumnResult(name = "valor_total", type = Double.class),
                        @ColumnResult(name = "valor_parcela", type = Double.class),
                        @ColumnResult(name = "id_associado", type = Long.class),
                        @ColumnResult(name = "nome_associado", type = String.class),
                        @ColumnResult(name = "salario_associado", type = Double.class),
                        @ColumnResult(name = "id_convenio", type = Long.class),
                        @ColumnResult(name = "nome_convenio", type = String.class),
                }))
@Table(name = "TB_REQUISICOES")
public class Requisicao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valorTotal;

    private BigDecimal valorParcela;

    @Enumerated(EnumType.STRING)
    private StatusRequisicao status;

    private String parcelaAtual;

    @Temporal(TemporalType.DATE)
    private Date dataRequisicao;

    @ManyToOne(optional = false,  fetch = FetchType.EAGER)
    private Associado associado;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Convenio convenio;

    private boolean isAvulso;

    public Requisicao() {
      this.isAvulso = false;
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

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(BigDecimal valorParcela) {
        this.valorParcela = valorParcela;
    }

    public StatusRequisicao getStatus() {
        return status;
    }

    public void setStatus(StatusRequisicao status) {
        this.status = status;
    }

    public Date getDataRequisicao() {
        return dataRequisicao;
    }

    public String getParcelaAtual() {
        return parcelaAtual;
    }

    public void setParcelaAtual(String parcelaAtual) {
        this.parcelaAtual = parcelaAtual;
    }

    public void setDataRequisicao(Date dataRequisicao) {
        this.dataRequisicao = dataRequisicao;
    }

    public boolean isAvulso() {
        return isAvulso;
    }

    public void setAvulso(boolean avulso) {
        isAvulso = avulso;
    }
}
