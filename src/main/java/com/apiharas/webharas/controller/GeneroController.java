package com.apiharas.webharas.controller;

import com.apiharas.webharas.entity.Genero;
import com.apiharas.webharas.interfaces.GeneroService;
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
public class GeneroController {

    private final GeneroService generoService;

    @GetMapping("/genero/{id}")
    public ResponseEntity<Optional<Genero>> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(generoService.getById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/generos")
    public ResponseEntity<List<Genero>> getAll() {
        try {
            return ResponseEntity.ok().body(generoService.getListItems());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/genero/save")
    public ResponseEntity<Genero> save(@RequestBody Genero genero) {
        try {
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/genero/save").toUriString());
            return ResponseEntity.created(uri).body(generoService.save(genero));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/genero/{id}")
    public ResponseEntity<Genero> remove(@PathVariable long id) {
        try {
            generoService.remove(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
