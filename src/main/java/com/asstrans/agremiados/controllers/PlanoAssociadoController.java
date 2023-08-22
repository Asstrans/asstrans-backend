package com.asstrans.agremiados.controllers;

import com.asstrans.agremiados.dto.PlanoAssociadoDto;
import com.asstrans.agremiados.model.PlanoAssociado;
import com.asstrans.agremiados.services.PlanoAssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/planos-associados")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PlanoAssociadoController {

    @Autowired
    private PlanoAssociadoService planoAssociadoService;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody PlanoAssociadoDto planoAssociadoDto) {
        return ResponseEntity.ok().body(planoAssociadoService.save(planoAssociadoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        planoAssociadoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(planoAssociadoService.findAll());
    }

    @GetMapping("/{id}/planos")
    public ResponseEntity<?> findAllPlanoAssociadoByAssociado(@PathVariable("id") Long idAssociado) {
        return ResponseEntity.ok().body(planoAssociadoService.findAllByAssociado(idAssociado));
    }


    @GetMapping("/associado/{idAssociado}/plano/{idPlano}")
    public ResponseEntity<?> verifyPlanoAssociado(@PathVariable("idAssociado") Long idAssociado, @PathVariable("idPlano") Long idPlano) {
        return ResponseEntity.ok().body(planoAssociadoService.findPlanoAssociado(idAssociado, idPlano));
    }
}
