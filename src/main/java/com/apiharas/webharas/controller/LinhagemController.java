package com.apiharas.webharas.controller;

import com.apiharas.webharas.entity.Linhagem;
import com.apiharas.webharas.interfaces.LinhagemService;
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
public class LinhagemController {

    private final LinhagemService linhagemService;

    @GetMapping("/linhagem/{id}")
    public ResponseEntity<Optional<Linhagem>> getLinhagemById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(linhagemService.getById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/linhagems")
    public ResponseEntity<List<Linhagem>> getLinhagems() {
        try {
            return ResponseEntity.ok().body(linhagemService.getListItems());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/linhagem/save")
    public ResponseEntity<Linhagem> saveLinhagem(@RequestBody Linhagem linhagem) {
        try {
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/linhagem/save").toUriString());
            return ResponseEntity.created(uri).body(linhagemService.save(linhagem));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/linhagem/{id}")
    public ResponseEntity<Linhagem> removeLinhagem(@PathVariable long id) {
        try {
            linhagemService.remove(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
