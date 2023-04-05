package com.asstrans.agremiados.controllers;

import com.asstrans.agremiados.dto.PlanoAssociadoDependenteDto;
import com.asstrans.agremiados.dto.PlanoAssociadoDto;
import com.asstrans.agremiados.services.PlanoAssociadoDependenteService;
import com.asstrans.agremiados.services.PlanoAssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/planos-associados-dependentes")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PlanoAssociadoDependenteController {

    @Autowired
    private PlanoAssociadoDependenteService planoAssociadoDependenteService;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody PlanoAssociadoDependenteDto planoAssociadoDependenteDto) {
        return ResponseEntity.ok().body(planoAssociadoDependenteService.save(planoAssociadoDependenteDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        planoAssociadoDependenteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/plano-associado/{idPlanoAssociado}/dependente/{idDependente}")
    public ResponseEntity<?> verifyPlanoAssociado(@PathVariable("idPlanoAssociado") Long idPlanoAssociado, @PathVariable("idDependente") Long idDependente) {
        return ResponseEntity.ok().body(planoAssociadoDependenteService.verifyPlanoAssociadoDependente(idPlanoAssociado, idDependente));
    }
}
