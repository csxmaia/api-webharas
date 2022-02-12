package com.apiharas.webharas.service;

import com.apiharas.webharas.entity.Pelagem;
import com.apiharas.webharas.interfaces.PelagemService;
import com.apiharas.webharas.repository.PelagemRepository;
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
public class PelagemServiceImplements implements PelagemService {
    private final PelagemRepository pelagemRepository;

    @Override
    public Pelagem save(Pelagem pelagem) {
        if (pelagem.getId() == null) {
            log.info("Salvando novo Pelagem {} no banco de dados", pelagem.getNome());
            return pelagemRepository.save(pelagem);
        } else {
            log.info("Atualizando Pelagem {} no banco de dados", pelagem.getNome());
            return pelagemRepository.save(pelagem);
        }
    }

    @Override
    public Optional<Pelagem> getById(Long id) {
        log.info("Buscando pelagem {}", id);
        return pelagemRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        Optional<Pelagem> cavalo = pelagemRepository.findById(id);
        log.info("Deletando pelagem {}", id);
        cavalo.ifPresent(pelagemRepository::delete);
    }

    @Override
    public List<Pelagem> getListItems() {
        log.info("Buscando pelagems");
        return pelagemRepository.findAll();
    }

}
