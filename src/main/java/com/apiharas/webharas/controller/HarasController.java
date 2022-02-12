package com.apiharas.webharas.controller;

import com.apiharas.webharas.entity.Haras;
import com.apiharas.webharas.interfaces.HarasService;
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
public class HarasController {

    private final HarasService harasService;

    @GetMapping("/haras/{id}")
    public ResponseEntity<Optional<Haras>> getHarasById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(harasService.getById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/harass")
    public ResponseEntity<List<Haras>> getHarass() {
        try {
            return ResponseEntity.ok().body(harasService.getListItems());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/haras/save")
    public ResponseEntity<Haras> saveHaras(@RequestBody Haras haras) {
        try {
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/haras/save").toUriString());
            return ResponseEntity.created(uri).body(harasService.save(haras));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/haras/{id}")
    public ResponseEntity<Haras> removeHaras(@PathVariable long id) {
        try {
            harasService.remove(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
