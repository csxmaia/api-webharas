package com.apiharas.webharas.service;

import com.apiharas.webharas.entity.Habilidade;
import com.apiharas.webharas.interfaces.HabilidadeService;
import com.apiharas.webharas.repository.HabilidadeRepository;
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
public class HabilidadeServiceImplements implements HabilidadeService {
    private final HabilidadeRepository habilidadeRepository;

    @Override
    public Habilidade save(Habilidade habilidade) {
        if (habilidade.getId() == null) {
            log.info("Salvando novo Habilidade {} no banco de dados", habilidade.getTipo());
            return habilidadeRepository.save(habilidade);
        } else {
            log.info("Atualizando Habilidade {} no banco de dados", habilidade.getTipo());
            return habilidadeRepository.save(habilidade);
        }
    }

    @Override
    public Optional<Habilidade> getById(Long id) {
        log.info("Buscando Habilidade {}", id);
        return habilidadeRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        Optional<Habilidade> habilidade = habilidadeRepository.findById(id);
        log.info("Deletando habilidade {}", id);
        habilidade.ifPresent(habilidadeRepository::delete);
    }

    @Override
    public List<Habilidade> getListItems() {
        log.info("Buscando habilidades");
        return habilidadeRepository.findAll();
    }

}
