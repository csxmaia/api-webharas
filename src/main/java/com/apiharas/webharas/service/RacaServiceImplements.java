package com.apiharas.webharas.service;

import com.apiharas.webharas.entity.Raca;
import com.apiharas.webharas.interfaces.RacaService;
import com.apiharas.webharas.repository.RacaRepository;
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
public class RacaServiceImplements implements RacaService {
    private final RacaRepository racaRepository;

    @Override
    public Raca save(Raca raca) {
        if (raca.getId() == null) {
            log.info("Salvando novo Raca {} no banco de dados", raca.getNome());
            return racaRepository.save(raca);
        } else {
            log.info("Atualizando Raca {} no banco de dados", raca.getNome());
            return racaRepository.save(raca);
        }
    }

    @Override
    public Optional<Raca> getById(Long id) {
        log.info("Buscando raca {}", id);
        return racaRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        Optional<Raca> cavalo = racaRepository.findById(id);
        log.info("Deletando raca {}", id);
        cavalo.ifPresent(racaRepository::delete);
    }

    @Override
    public List<Raca> getListItems() {
        log.info("Buscando racas");
        return racaRepository.findAll();
    }

}
