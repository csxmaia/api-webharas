package com.apiharas.webharas.service;

import com.apiharas.webharas.entity.Haras;
import com.apiharas.webharas.interfaces.HarasService;
import com.apiharas.webharas.repository.HarasRepository;
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
public class HarasServiceImplements implements HarasService {
    private final HarasRepository harasRepository;

    @Override
    public Haras save(Haras haras) {
        if (haras.getId() == null) {
            log.info("Salvando novo Haras {} no banco de dados", haras.getNome());
            return harasRepository.save(haras);
        } else {
            log.info("Atualizando Haras {} no banco de dados", haras.getNome());
            return harasRepository.save(haras);
        }
    }

    @Override
    public Optional<Haras> getById(Long id) {
        log.info("Buscando haras {}", id);
        return harasRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        Optional<Haras> cavalo = harasRepository.findById(id);
        log.info("Deletando haras {}", id);
        cavalo.ifPresent(harasRepository::delete);
    }

    @Override
    public List<Haras> getListItems() {
        log.info("Buscando harass");
        return harasRepository.findAll();
    }

}
