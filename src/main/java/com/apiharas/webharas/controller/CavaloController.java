package com.apiharas.webharas.controller;

import com.apiharas.webharas.entity.Cavalo;
import com.apiharas.webharas.interfaces.CavaloService;
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
public class CavaloController {

    private final CavaloService cavaloService;

    @GetMapping("/cavalo/{id}")
    public ResponseEntity<Optional<Cavalo>> getCavalo(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(cavaloService.getCavaloById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/cavalos")
    public ResponseEntity<List<Cavalo>> getCavalos() {
        try {
            return ResponseEntity.ok().body(cavaloService.getCavalos());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/cavalo/save")
    public ResponseEntity<Cavalo> saveCavalo(@RequestBody Cavalo cavalo) {
        try {
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/cavalo/save").toUriString());
            return ResponseEntity.created(uri).body(cavaloService.saveCavalo(cavalo));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/cavalo/{id}")
    public ResponseEntity<Cavalo> removeCavalo(@PathVariable long id) {
        try {
            cavaloService.removeCavalo(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
