package com.apiharas.webharas.service;

import com.apiharas.webharas.entity.Imagem;
import com.apiharas.webharas.interfaces.ImagemService;
import com.apiharas.webharas.repository.ImagemRepository;
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
public class ImagemServiceImplements implements ImagemService {
    private final ImagemRepository imagemRepository;

    @Override
    public Imagem save(Imagem imagem) {
        if (imagem.getId() == null) {
            log.info("Salvando novo Imagem {} no banco de dados", imagem.getUrl());
            return imagemRepository.save(imagem);
        } else {
            log.info("Atualizando Imagem {} no banco de dados", imagem.getUrl());
            return imagemRepository.save(imagem);
        }
    }

    @Override
    public Optional<Imagem> getById(Long id) {
        log.info("Buscando imagem {}", id);
        return imagemRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        Optional<Imagem> cavalo = imagemRepository.findById(id);
        log.info("Deletando imagem {}", id);
        cavalo.ifPresent(imagemRepository::delete);
    }

    @Override
    public List<Imagem> getListItems() {
        log.info("Buscando imagems");
        return imagemRepository.findAll();
    }

}
