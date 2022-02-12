package com.apiharas.webharas.controller;

import com.apiharas.webharas.entity.Cavalo;
import com.apiharas.webharas.entity.Estado;
import com.apiharas.webharas.interfaces.EstadoService;
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
public class EstadoController {

    private final EstadoService estadoService;

    @GetMapping("/estado/{id}")
    public ResponseEntity<Optional<Estado>> getEstadoById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(estadoService.getById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/estados")
    public ResponseEntity<List<Estado>> getEstados() {
        try {
            return ResponseEntity.ok().body(estadoService.getListItems());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/estado/save")
    public ResponseEntity<Estado> saveEstado(@RequestBody Estado estado) {
        try {
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/estado/save").toUriString());
            return ResponseEntity.created(uri).body(estadoService.save(estado));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/estado/{id}")
    public ResponseEntity<Estado> removeEstado(@PathVariable long id) {
        try {
            estadoService.remove(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
