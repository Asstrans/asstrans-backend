package com.asstrans.agremiados.services.impl;

import com.asstrans.agremiados.dto.RequisicaoConvenioTotal;
import com.asstrans.agremiados.dto.RequisicaoDto;
import com.asstrans.agremiados.dto.RequisicaoTotal;
import com.asstrans.agremiados.enums.StatusParcela;
import com.asstrans.agremiados.enums.StatusRequisicao;
import com.asstrans.agremiados.model.Parcela;
import com.asstrans.agremiados.model.Requisicao;
import com.asstrans.agremiados.repositories.AssociadoRepository;
import com.asstrans.agremiados.repositories.ConvenioRepository;
import com.asstrans.agremiados.repositories.ParcelaRepository;
import com.asstrans.agremiados.repositories.RequisicaoRepository;
import com.asstrans.agremiados.services.RequisicaoService;
import com.asstrans.agremiados.services.exceptions.LimiteExcedidoException;
import com.asstrans.agremiados.utils.DataUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequisicaoServiceImpl implements RequisicaoService {

    @Autowired
    private RequisicaoRepository requisicaoRepository;

    @Autowired
    private ParcelaRepository parcelaRepository;
    @Autowired
    private AssociadoRepository associadoRepository;

    @Autowired
    private ConvenioRepository convenioRepository;



    @Override
    @Transactional
    public void darBaixaParcela(Long idRequisicao, Long idParcela){
        final  var requisicao = requisicaoRepository.findById(idRequisicao);
        final var associado = associadoRepository.findById(requisicao.get().getAssociado().getId());
        final  var parcela = parcelaRepository.findById(idParcela);
        parcela.get().setStatus(StatusParcela.PAGO);
        final var parcelas =  findAllParcelasByRequisicao(requisicao.get().getId());
        requisicao.get().setParcelaAtual(parcela.get().getName().split(" ")[1]+"/"+parcelas.size());
        if(confirmBaixaRequisicao(parcelas)){
            final var requisicoes = requisicaoRepository.findRequisicoesByAssociado(associado.get().getId());
            final var total = getValorParcelaRequisicoes(requisicoes);
            associado.get().setLimiteUtilizado(associado.get().getLimiteUtilizado().subtract(total.add(requisicao.get().getValorParcela())));
            requisicao.get().setStatus(StatusRequisicao.QUITADO);

        }
    }

    private boolean confirmBaixaRequisicao(List<Parcela> parcelas){
        boolean isBaixa = false;
        final var total = parcelas.stream()
                .filter((parcela) -> parcela.getStatus().equals(StatusParcela.PENDENTE))
                .collect(Collectors.toList());
        if(total.size() == 0){
            isBaixa = true;
        }
        return isBaixa;
    }
    @Override
    public List<Parcela> findAllParcelasByRequisicao(Long idRequisicao){
        return parcelaRepository.findAllParcelasByRequisicao(idRequisicao);
    }
    @Override
    public Page<Requisicao> findAllByAssociadoAndConvenio(Long idAssociado, Long idConvenio, Pageable pageable) {
        return requisicaoRepository.findAllByAssociadoAndConvenio(idAssociado, idConvenio, pageable);
    }
    @Override
    public Page<Requisicao> findAllByAssociado(Long idAssociado, Pageable pageable) {
        return requisicaoRepository.findAllByAssociado(idAssociado, pageable);
    }
    @Override
    public Page<Requisicao> findAllByConvenio(Long idConvenio, Pageable pageable) {
        return requisicaoRepository.findAllByConvenio(idConvenio, pageable);
    }
    @Override
    public Page<Requisicao> findAll(Pageable pageable) {
        return requisicaoRepository.findAll(pageable);
    }

    @Override
    public List<Parcela> findAllParcelasPagasByRequisicao(Long idRequisicao){
        return parcelaRepository.findAllParcelasPagasByRequisicao(idRequisicao);
    }

    @Override
    @Transactional
    public Requisicao save(RequisicaoDto requisicaoDto) {

        final var quantidadeParcelas = requisicaoDto.getQuantidadeParcelas();
        final var valorTotal = requisicaoDto.getValorTotal();
        final var valorParcela = valorTotal.divide(new BigDecimal(quantidadeParcelas), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP);

        final var associado = associadoRepository.findById(requisicaoDto.getAssociadoId());
        final var convenio = convenioRepository.findById(requisicaoDto.getConvenioId());

        if((associado.get().getLimiteTotal().doubleValue() - associado.get().getLimiteUtilizado().doubleValue() < valorParcela.doubleValue())){
            throw new LimiteExcedidoException("Valor excedeu o limite do associado");
        }

        final var requisicao = new Requisicao();

        requisicao.setAssociado(associado.get());
        requisicao.setConvenio(convenio.get());
        requisicao.setValorParcela(valorParcela);
        requisicao.setValorTotal(valorTotal);
        requisicao.setStatus(StatusRequisicao.PENDENTE);

        final var requisicaoSalva  = requisicaoRepository.save(requisicao);

        this.parcelaRepository.saveAll(gerarParcelas(quantidadeParcelas, valorParcela, requisicaoSalva));
        return  requisicaoSalva;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        var parcelas = parcelaRepository.findAllParcelasByRequisicao(id);
        parcelaRepository.deleteAllInBatch(parcelas);
        var requisicao = requisicaoRepository.findById(id);
        this.requisicaoRepository.delete(requisicao.get());
    }

    @Override
    public Requisicao findById(Long id) {
        return requisicaoRepository.findById(id).get();
    }
    @Transactional
    @Override
    public void aceitar(Long id) {
       final var requisicao = requisicaoRepository.findById(id).get();
       final var associado = associadoRepository.findById(requisicao.getAssociado().getId());
       final var requisicoes = requisicaoRepository.findRequisicoesByAssociado(associado.get().getId());

       final var parcelas =  findAllParcelasByRequisicao(requisicao.getId());
       final var total = getValorParcelaRequisicoes(requisicoes);

       requisicao.setParcelaAtual(""+1+"/"+parcelas.size());

       Calendar calendar = Calendar.getInstance();
        int mesAtual = calendar.get(Calendar.MONTH);
        requisicao.setDataRequisicao(calendar.getTime());
        if (mesAtual == Calendar.DECEMBER) {
            calendar.add(Calendar.MONTH, 1);
        }
        var dataReferencia = calendar.getTime();
        requisicao.setDataReferencia(dataReferencia);


       requisicao.setStatus(StatusRequisicao.ABERTA);
       associado.get().setLimiteUtilizado(associado.get().getLimiteUtilizado().add(total.add(requisicao.getValorParcela())));
    }

    @Transactional
    @Override
    public void reprovar(Long id) {
        final var requisicao = requisicaoRepository.findById(id).get();
        requisicao.setStatus(StatusRequisicao.CANCELADA);
    }

    private BigDecimal getValorParcelaRequisicoes(List<Requisicao> requisicoes){
         var valor = new BigDecimal(0);
        for (Requisicao requisicao: requisicoes) {
            valor = valor.add(requisicao.getValorParcela());
        }
        return valor;
    }

    private List<Parcela> gerarParcelas(Long quantidadeParcelas, BigDecimal valorParcela, Requisicao requisicao) {
        final var listParcelas = new ArrayList<Parcela>();
        int mesAtual = DataUtils.getMesAtual();
        for (int i =0; i< quantidadeParcelas; i++){
            listParcelas.add(new Parcela(null, "PARCELA " + (i+1), valorParcela, StatusParcela.PENDENTE, DataUtils.getUltimoDiaDoMes(++mesAtual), requisicao));
        }
        return listParcelas;
    }

    @Transactional(readOnly = false)
    public List<Requisicao> reportUnificada(int mes, int ano) {
        return this.requisicaoRepository.reportUnificada(mes, ano);
    }

    @Transactional(readOnly = false)
    public List<RequisicaoTotal> reportUnificadaTotal(int mes, int ano) {
        return this.requisicaoRepository.reportUnificadaTotal(mes, ano);
    }

    @Transactional(readOnly = false)
    public List<Requisicao> reportNormal(int mes, int ano) {
        return this.requisicaoRepository.reportNormal(mes, ano);
    }

    @Transactional(readOnly = false)
    public List<RequisicaoConvenioTotal> reportNormalTotal(int mes, int ano) {
        return this.requisicaoRepository.reportNormalTotal(mes, ano);
    }

    @Override
    public long count() {
        return  requisicaoRepository.count();
    }

}
