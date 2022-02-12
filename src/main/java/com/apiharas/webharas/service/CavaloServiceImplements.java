package com.apiharas.webharas.service;

import com.apiharas.webharas.entity.Cavalo;
import com.apiharas.webharas.interfaces.CavaloService;
import com.apiharas.webharas.repository.CavaloRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CavaloServiceImplements implements CavaloService {
    private final CavaloRepository cavaloRepository;

    @Override
    public Cavalo saveCavalo(Cavalo cavalo) {
        if (cavalo.getId() == null) {
            log.info("Salvando novo cavalo {} no banco de dados", cavalo.getNome());
            return cavaloRepository.save(cavalo);
        } else {
            log.info("Atualizando Estado {} no banco de dados", cavalo.getNome());
            return cavaloRepository.save(cavalo);
        }
    }

    @Override
    public Optional<Cavalo> getCavaloById(Long cavalo) {
        log.info("Buscando cavalo {}", cavalo);
        return cavaloRepository.findById(cavalo);
    }

    @Override
    public void removeCavalo(Long idCavalo) {
        Optional<Cavalo> cavalo = cavaloRepository.findById(idCavalo);
        log.info("Deletando cavalo {}", idCavalo);
        cavalo.ifPresent(cavaloRepository::delete);
    }

    @Override
    public List<Cavalo> getCavalos() {
        log.info("Buscando cavalos");
        return cavaloRepository.findAll();
    }
}
