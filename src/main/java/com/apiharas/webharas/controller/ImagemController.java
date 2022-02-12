package com.apiharas.webharas.controller;

import com.apiharas.webharas.entity.Imagem;
import com.apiharas.webharas.interfaces.ImagemService;
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
public class ImagemController {

    private final ImagemService imagemService;

    @GetMapping("/imagem/{id}")
    public ResponseEntity<Optional<Imagem>> getImagemById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(imagemService.getById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/imagems")
    public ResponseEntity<List<Imagem>> getImagems() {
        try {
            return ResponseEntity.ok().body(imagemService.getListItems());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/imagem/save")
    public ResponseEntity<Imagem> saveImagem(@RequestBody Imagem imagem) {
        try {
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/imagem/save").toUriString());
            return ResponseEntity.created(uri).body(imagemService.save(imagem));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/imagem/{id}")
    public ResponseEntity<Imagem> removeImagem(@PathVariable long id) {
        try {
            imagemService.remove(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
