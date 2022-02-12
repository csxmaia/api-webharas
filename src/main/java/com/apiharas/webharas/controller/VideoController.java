package com.apiharas.webharas.controller;

import com.apiharas.webharas.entity.Video;
import com.apiharas.webharas.interfaces.VideoService;
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
public class VideoController {

    private final VideoService videoService;

    @GetMapping("/video/{id}")
    public ResponseEntity<Optional<Video>> getVideoById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(videoService.getById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/videos")
    public ResponseEntity<List<Video>> getVideos() {
        try {
            return ResponseEntity.ok().body(videoService.getListItems());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/video/save")
    public ResponseEntity<Video> saveVideo(@RequestBody Video video) {
        try {
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/video/save").toUriString());
            return ResponseEntity.created(uri).body(videoService.save(video));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/video/{id}")
    public ResponseEntity<Video> removeVideo(@PathVariable long id) {
        try {
            videoService.remove(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
