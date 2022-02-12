package com.apiharas.webharas.service;

import com.apiharas.webharas.entity.Cavalo;
import com.apiharas.webharas.entity.Estado;
import com.apiharas.webharas.interfaces.EstadoService;
import com.apiharas.webharas.repository.EstadoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EstadoServiceImplements implements EstadoService {
    private final EstadoRepository estadoRepository;

    @Override
    public Estado save(Estado estado) {
        if (estado.getId() == null) {
            log.info("Salvando novo Estado {} no banco de dados", estado.getNome());
            return estadoRepository.save(estado);
        } else {
            log.info("Atualizando Estado {} no banco de dados", estado.getNome());
            return estadoRepository.save(estado);
        }
    }

    @Override
    public Optional<Estado> getById(Long id) {
        log.info("Buscando estado {}", id);
        return estadoRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        Optional<Estado> cavalo = estadoRepository.findById(id);
        log.info("Deletando estado {}", id);
        cavalo.ifPresent(estadoRepository::delete);
    }

    @Override
    public List<Estado> getListItems() {
        log.info("Buscando estados");
        return estadoRepository.findAll();
    }

}
