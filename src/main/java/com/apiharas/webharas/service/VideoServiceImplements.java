package com.apiharas.webharas.service;

import com.apiharas.webharas.entity.Video;
import com.apiharas.webharas.interfaces.VideoService;
import com.apiharas.webharas.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class VideoServiceImplements implements VideoService {
    private final VideoRepository videoRepository;

    @Override
    public Video save(Video video) {
        if (video.getId() == null) {
            log.info("Salvando novo Video {} no banco de dados", video.getUrl());
            return videoRepository.save(video);
        } else {
            log.info("Atualizando Video {} no banco de dados", video.getUrl());
            return videoRepository.save(video);
        }
    }

    @Override
    public Optional<Video> getById(Long id) {
        log.info("Buscando video {}", id);
        return videoRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        Optional<Video> cavalo = videoRepository.findById(id);
        log.info("Deletando video {}", id);
        cavalo.ifPresent(videoRepository::delete);
    }

    @Override
    public List<Video> getListItems() {
        log.info("Buscando videos");
        return videoRepository.findAll();
    }

}
