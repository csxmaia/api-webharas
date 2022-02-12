package com.apiharas.webharas.controller;

import com.apiharas.webharas.entity.Ancestrais;
import com.apiharas.webharas.interfaces.AncestraisService;
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
public class AncestraisController {

    private final AncestraisService ancestraisService;

    @GetMapping("/ancestral/{id}")
    public ResponseEntity<Optional<Ancestrais>> getAncestralById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(ancestraisService.getById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/ancestrais")
    public ResponseEntity<List<Ancestrais>> getAncestrais() {
        try {
            return ResponseEntity.ok().body(ancestraisService.getListItems());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/ancestral/save")
    public ResponseEntity<Ancestrais> saveAncestral(@RequestBody Ancestrais ancestral) {
        try {
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/ancestral/save").toUriString());
            return ResponseEntity.created(uri).body(ancestraisService.save(ancestral));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/ancestral/{id}")
    public ResponseEntity<Ancestrais> removeAncestral(@PathVariable long id) {
        try {
            ancestraisService.remove(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
