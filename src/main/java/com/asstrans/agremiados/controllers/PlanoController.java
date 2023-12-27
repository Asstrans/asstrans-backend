package com.asstrans.agremiados.controllers;

import com.asstrans.agremiados.dto.PlanoDto;
import com.asstrans.agremiados.dto.UpdatePlanoDto;
import com.asstrans.agremiados.services.PlanoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/planos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PlanoController {
    @Autowired
    private PlanoService planoService;


    @GetMapping("/count")
    public ResponseEntity<?> findAllPlanosCount() {
        return ResponseEntity.ok().body(planoService.count());
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody PlanoDto planoDto) {
        return ResponseEntity.ok().body(planoService.save(planoDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody UpdatePlanoDto updatePlanoDto) {
        return ResponseEntity.ok().body(planoService.update(id, updatePlanoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable("id") Long id) {
        planoService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/search")
    public ResponseEntity<?> search(
            @RequestParam(value = "param", required = false) String search,
            @PageableDefault(page = 0, size = 10, sort="id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.ok().body(planoService.findAllIgnoreCase(search, pageable));
    }
    @GetMapping
    public ResponseEntity<?> findAll(@PageableDefault(page = 0, size = 10, sort="id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok().body(planoService.findAll(pageable));
    }
}
