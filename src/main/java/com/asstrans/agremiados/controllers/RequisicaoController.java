package com.asstrans.agremiados.controllers;

import com.asstrans.agremiados.model.Associado;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requisicoes")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RequisicaoController {


    @PostMapping
    public ResponseEntity<?> save(@RequestBody Associado associado) {
        return ResponseEntity.ok().body(associadoService.save(associado));
    }
}
