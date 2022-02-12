package com.apiharas.webharas.service;

import com.apiharas.webharas.entity.Linhagem;
import com.apiharas.webharas.interfaces.LinhagemService;
import com.apiharas.webharas.repository.LinhagemRepository;
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
public class LinhagemServiceImplements implements LinhagemService {
    private final LinhagemRepository linhagemRepository;

    @Override
    public Linhagem save(Linhagem linhagem) {
        if (linhagem.getId() == null) {
            log.info("Salvando novo Linhagem {} no banco de dados", linhagem.getNome());
            return linhagemRepository.save(linhagem);
        } else {
            log.info("Atualizando Linhagem {} no banco de dados", linhagem.getNome());
            return linhagemRepository.save(linhagem);
        }
    }

    @Override
    public Optional<Linhagem> getById(Long id) {
        log.info("Buscando linhagem {}", id);
        return linhagemRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        Optional<Linhagem> cavalo = linhagemRepository.findById(id);
        log.info("Deletando linhagem {}", id);
        cavalo.ifPresent(linhagemRepository::delete);
    }

    @Override
    public List<Linhagem> getListItems() {
        log.info("Buscando linhagems");
        return linhagemRepository.findAll();
    }

}
