package com.apiharas.webharas.service;

import com.apiharas.webharas.entity.Ancestrais;
import com.apiharas.webharas.interfaces.AncestraisService;
import com.apiharas.webharas.repository.AncestraisRepository;
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
public class AncestraisServiceImplements implements AncestraisService {
    private final AncestraisRepository ancestraisRepository;

    @Override
    public Ancestrais save(Ancestrais ancestrais) {
        if (ancestrais.getId() == null) {
            log.info("Salvando novo Ancestrais {} no banco de dados", ancestrais.getNome());
            return ancestraisRepository.save(ancestrais);
        } else {
            log.info("Atualizando Ancestrais {} no banco de dados", ancestrais.getNome());
            return ancestraisRepository.save(ancestrais);
        }
    }

    @Override
    public Optional<Ancestrais> getById(Long id) {
        log.info("Buscando Ancestrais {}", id);
        return ancestraisRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        Optional<Ancestrais> ancestrais = ancestraisRepository.findById(id);
        log.info("Deletando ancestrais {}", id);
        ancestrais.ifPresent(ancestraisRepository::delete);
    }

    @Override
    public List<Ancestrais> getListItems() {
        log.info("Buscando ancestrais");
        return ancestraisRepository.findAll();
    }

}
