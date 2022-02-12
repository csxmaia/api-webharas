package com.apiharas.webharas.controller;

import com.apiharas.webharas.entity.Habilidade;
import com.apiharas.webharas.interfaces.HabilidadeService;
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
public class HabilidadeController {

    private final HabilidadeService habilidadeService;

    @GetMapping("/habilidade/{id}")
    public ResponseEntity<Optional<Habilidade>> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(habilidadeService.getById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/habilidades")
    public ResponseEntity<List<Habilidade>> getAll() {
        try {
            return ResponseEntity.ok().body(habilidadeService.getListItems());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/habilidade/save")
    public ResponseEntity<Habilidade> save(@RequestBody Habilidade habilidade) {
        try {
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/habilidade/save").toUriString());
            return ResponseEntity.created(uri).body(habilidadeService.save(habilidade));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/habilidade/{id}")
    public ResponseEntity<Habilidade> remove(@PathVariable long id) {
        try {
            habilidadeService.remove(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
