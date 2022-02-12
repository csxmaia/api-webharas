package com.apiharas.webharas.controller;

import com.apiharas.webharas.entity.Raca;
import com.apiharas.webharas.interfaces.RacaService;
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
public class RacaController {

    private final RacaService racaService;

    @GetMapping("/raca/{id}")
    public ResponseEntity<Optional<Raca>> getRacaById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(racaService.getById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/racas")
    public ResponseEntity<List<Raca>> getRacas() {
        try {
            return ResponseEntity.ok().body(racaService.getListItems());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/raca/save")
    public ResponseEntity<Raca> saveRaca(@RequestBody Raca raca) {
        try {
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/raca/save").toUriString());
            return ResponseEntity.created(uri).body(racaService.save(raca));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/raca/{id}")
    public ResponseEntity<Raca> removeRaca(@PathVariable long id) {
        try {
            racaService.remove(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
