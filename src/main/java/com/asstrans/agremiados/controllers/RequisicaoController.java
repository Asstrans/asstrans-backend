package com.asstrans.agremiados.controllers;

import com.asstrans.agremiados.dto.RequisicaoDto;
import com.asstrans.agremiados.model.Associado;
import com.asstrans.agremiados.services.RequisicaoService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
