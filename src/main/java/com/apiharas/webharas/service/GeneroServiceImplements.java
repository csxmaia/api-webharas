package com.apiharas.webharas.service;

import com.apiharas.webharas.entity.Genero;
import com.apiharas.webharas.interfaces.GeneroService;
import com.apiharas.webharas.repository.GeneroRepository;
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
public class GeneroServiceImplements implements GeneroService {
    private final GeneroRepository generoRepository;

    @Override
    public Genero save(Genero genero) {
        if (genero.getId() == null) {
            log.info("Salvando novo Genero {} no banco de dados", genero.getTipo());
            return generoRepository.save(genero);
        } else {
            log.info("Atualizando Genero {} no banco de dados", genero.getTipo());
            return generoRepository.save(genero);
        }
    }

    @Override
    public Optional<Genero> getById(Long id) {
        log.info("Buscando Genero {}", id);
        return generoRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        Optional<Genero> genero = generoRepository.findById(id);
        log.info("Deletando genero {}", id);
        genero.ifPresent(generoRepository::delete);
    }

    @Override
    public List<Genero> getListItems() {
        log.info("Buscando generos");
        return generoRepository.findAll();
    }

}
