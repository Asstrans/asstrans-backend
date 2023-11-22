package com.asstrans.agremiados.controllers;

import com.asstrans.agremiados.dto.AssociadoDto;
import com.asstrans.agremiados.dto.UpdateDependenteDto;
import com.asstrans.agremiados.model.Associado;
import com.asstrans.agremiados.model.Dependente;
import com.asstrans.agremiados.repositories.AssociadoRepository;
import com.asstrans.agremiados.services.AssociadoService;
import com.asstrans.agremiados.services.DependenteService;
import com.asstrans.agremiados.specification.SpecificationTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/associados")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AssociadoController {

    @Autowired
    private AssociadoService associadoService;

    @Autowired
    private AssociadoRepository associadoRepository;

    @Autowired
    private DependenteService dependenteService;

    @GetMapping("/all")
    public ResponseEntity<List<Associado>> findAllAssociados() {
        return ResponseEntity.ok().body(associadoRepository.findAll());
    }

    @GetMapping
    public ResponseEntity<Page<Associado>> findAll(
                                                  @RequestParam(value = "search", required = false) String search,
                                                  @PageableDefault(page = 0, size = 10, sort="id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok().body(associadoService.findAllSearch(search,pageable));
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(
            @RequestParam(value = "search", required = false) String search,
            @PageableDefault(page = 0, size = 10, sort="id", direction = Sort.Direction.ASC) Pageable pageable){

        return ResponseEntity.ok().body(associadoService.findAllSearch(search, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> finfById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(associadoService.findById(id));
    }

    @GetMapping("/{id}/dependentes")
    public ResponseEntity<?> findAllDependentesByAssociado(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(dependenteService.findByAssociado(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Associado associado) {
        return ResponseEntity.ok().body(associadoService.save(associado));
    }

    @PostMapping("/{id}/dependente")
    public ResponseEntity<?> saveDependente(@PathVariable Long id, @RequestBody Dependente dependente) {
        return ResponseEntity.ok().body(associadoService.saveDependente(id, dependente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AssociadoDto associadoDto) {
        return ResponseEntity.ok().body(associadoService.update(id,associadoDto));
    }

    @PutMapping("/{id}/dependente")
    public ResponseEntity<?> updateDependente(@PathVariable Long id, @RequestBody UpdateDependenteDto updateDependenteDto) {
        return ResponseEntity.ok().body(dependenteService.updateDependente(id,updateDependenteDto));
    }

    @DeleteMapping("/dependentes/{id}")
    public ResponseEntity<?> deleteDependente(@PathVariable Long id) {
        dependenteService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/deactive/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        associadoService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
