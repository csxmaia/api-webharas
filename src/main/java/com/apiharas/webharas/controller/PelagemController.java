package com.apiharas.webharas.controller;

import com.apiharas.webharas.entity.Pelagem;
import com.apiharas.webharas.interfaces.PelagemService;
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
public class PelagemController {

    private final PelagemService pelagemService;

    @GetMapping("/pelagem/{id}")
    public ResponseEntity<Optional<Pelagem>> getPelagemById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(pelagemService.getById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/pelagens")
    public ResponseEntity<List<Pelagem>> getPelagems() {
        try {
            return ResponseEntity.ok().body(pelagemService.getListItems());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/pelagem/save")
    public ResponseEntity<Pelagem> savePelagem(@RequestBody Pelagem pelagem) {
        try {
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/pelagem/save").toUriString());
            return ResponseEntity.created(uri).body(pelagemService.save(pelagem));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/pelagem/{id}")
    public ResponseEntity<Pelagem> removePelagem(@PathVariable long id) {
        try {
            pelagemService.remove(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
