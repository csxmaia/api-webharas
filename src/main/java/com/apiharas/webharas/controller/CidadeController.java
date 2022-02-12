package com.apiharas.webharas.controller;

import com.apiharas.webharas.entity.Cidade;
import com.apiharas.webharas.entity.Estado;
import com.apiharas.webharas.interfaces.CidadeService;
import lombok.RequiredArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CidadeController {

    private final CidadeService cidadeService;

    @GetMapping("/cidade/{id}")
    public ResponseEntity<Optional<Cidade>> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(cidadeService.getById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/cidades")
    public ResponseEntity<List<Cidade>> getAll() {
        try {
            return ResponseEntity.ok().body(cidadeService.getListItems());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/cidade/save")
    public ResponseEntity<Cidade> save(@RequestBody Cidade cidade) {
        try {
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/cidade/save").toUriString());
            return ResponseEntity.created(uri).body(cidadeService.save(cidade));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/cidade/{id}")
    public ResponseEntity<Cidade> remove(@PathVariable long id) {
        try {
            cidadeService.remove(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
