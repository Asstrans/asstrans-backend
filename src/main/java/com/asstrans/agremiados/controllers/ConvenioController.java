package com.asstrans.agremiados.controllers;

import com.asstrans.agremiados.dto.ConvenioDto;
import com.asstrans.agremiados.model.Convenio;
import com.asstrans.agremiados.services.ConvenioService;
import com.asstrans.agremiados.specification.SpecificationTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/convenios")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConvenioController {

    @Autowired
    private ConvenioService convenioService;

    @GetMapping
    public ResponseEntity<Page<Convenio>> findAll(SpecificationTemplate.ConvenioSpec spec,
                                                  @PageableDefault(page = 0, size = 10, sort="id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok().body(convenioService.findAll(spec,pageable));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ConvenioDto convenioDto) {
        return ResponseEntity.ok().body(convenioService.save(convenioDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody ConvenioDto convenioDto) {
        return ResponseEntity.ok().body(convenioService.update(id,convenioDto));
    }

    @PutMapping("/deactive/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        convenioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
