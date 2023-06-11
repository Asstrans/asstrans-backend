package com.asstrans.agremiados.controllers;

import com.asstrans.agremiados.dto.AceitarRequisicaoDto;
import com.asstrans.agremiados.dto.ParcelaBaixaDto;
import com.asstrans.agremiados.dto.ReprovarRequisicaoDto;
import com.asstrans.agremiados.dto.RequisicaoDto;
import com.asstrans.agremiados.model.Requisicao;
import com.asstrans.agremiados.services.RequisicaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requisicoes")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RequisicaoController {

    @Autowired
    private RequisicaoService requisicaoService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody RequisicaoDto requisicaoDto) {
        return ResponseEntity.ok().body(requisicaoService.save(requisicaoDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return  ResponseEntity.ok().body(requisicaoService.findById(id));
    }

    @PostMapping("/aceitar")
    public ResponseEntity<?> aceitarRequisicao(@RequestBody AceitarRequisicaoDto aceitarRequisicaoDto){
        this.requisicaoService.aceitar(aceitarRequisicaoDto.idRequisicao());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/reprovar")
    public ResponseEntity<?> reprovarRequisicao(@RequestBody ReprovarRequisicaoDto reprovarRequisicaoDto){
        this.requisicaoService.reprovar(reprovarRequisicaoDto.idRequisicao());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/parcelas/baixa")
    public ResponseEntity<?> aceitarRequisicao(@RequestBody ParcelaBaixaDto parcelaBaixaDto){
        this.requisicaoService.darBaixaParcela(parcelaBaixaDto.idRequisicao(), parcelaBaixaDto.idParcela());
        return ResponseEntity.noContent().build();
    }


    @GetMapping
    public ResponseEntity<Page<Requisicao>> findAll(@RequestParam(value = "convenio", required = false) String idConvenio,
                                                    @RequestParam(value = "associado", required = false) String idAssociado,
                                                    @PageableDefault(page = 0, size = 10, sort="id", direction = Sort.Direction.ASC) Pageable pageable) {

        Page<Requisicao> page = null;
        if(idConvenio == null && idAssociado == null ){
           page = requisicaoService.findAll(pageable);
        }else if(idConvenio == null && idAssociado != null){
            page = requisicaoService.findAllByAssociado(Long.parseLong(idAssociado), pageable);
        }else if(idAssociado == null && idConvenio != null){
            page = requisicaoService.findAllByConvenio(Long.parseLong(idConvenio), pageable);
        }else{
            page = requisicaoService.findAllByAssociadoAndConvenio(Long.parseLong(idAssociado), Long.parseLong(idConvenio), pageable);
        }

        return ResponseEntity.ok().body(page);
    }

    @GetMapping("/{id}/parcelas")
    public ResponseEntity<?> findAllParcelasByRequisicao(@PathVariable("id") Long id){
        return  ResponseEntity.ok().body(requisicaoService.findAllParcelasByRequisicao(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        requisicaoService.delete(id);
      return ResponseEntity.noContent().build();
    }


    //REPORT
    @GetMapping("/unificada")
    public ResponseEntity<?> reportUnificada(@RequestParam(value = "mes", required = false) int mes){
        return  ResponseEntity.ok().body(requisicaoService.reportUnificada(mes));
    }
    @GetMapping("/unificada/total")
    public ResponseEntity<?> reportUnificadaTotal(@RequestParam(value = "mes", required = false) int mes){
        return  ResponseEntity.ok().body(requisicaoService.reportUnificadaTotal(mes));
    }

    @GetMapping("/normal")
    public ResponseEntity<?> reportNormal(@RequestParam(value = "mes", required = false) int mes){
        return  ResponseEntity.ok().body(requisicaoService.reportNormal(mes));
    }
    @GetMapping("/normal/total")
    public ResponseEntity<?> reportNormalTotal(@RequestParam(value = "mes", required = false) int mes){
        return  ResponseEntity.ok().body(requisicaoService.reportNormalTotal(mes));
    }
}
