package com.apiharas.webharas.controller;

import com.apiharas.webharas.entity.Cavalo;
import com.apiharas.webharas.interfaces.CavaloService;
import lombok.RequiredArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

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
    public ResponseEntity<List<Cavalo>> getCavalos(
        @RequestParam (required = false) Long cidade,
        @RequestParam (required = false) Long genero,
        @RequestParam (required = false) Long raca,
        @RequestParam (required = false) Long pelagem
    ) {
        try {
            if(cidade != null || genero != null || raca != null || pelagem != null) {
                return ResponseEntity.ok().body(cavaloService.getCavalos(cidade, genero, raca, pelagem));
            }else {
                return ResponseEntity.ok().body(cavaloService.getCavalos());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/cavalosByUser")
    public ResponseEntity<List<Cavalo>> getCavalosByUser(HttpServletRequest request) {
        try {
            String authorizationHeader = request.getHeader(AUTHORIZATION);
            return ResponseEntity.ok().body(cavaloService.getCavalosByUser(authorizationHeader));
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
