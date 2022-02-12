package com.apiharas.webharas.service;

import com.apiharas.webharas.entity.Cidade;
import com.apiharas.webharas.entity.Estado;
import com.apiharas.webharas.interfaces.CidadeService;
import com.apiharas.webharas.repository.CidadeRepository;
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
public class CidadeServiceImplements implements CidadeService {
    private final CidadeRepository cidadeRepository;

    @Override
    public Cidade save(Cidade cidade) {
        if (cidade.getId() == null) {
            log.info("Salvando novo Cidade {} no banco de dados", cidade.getNome());
            return cidadeRepository.save(cidade);
        } else {
            log.info("Atualizando Cidade {} no banco de dados", cidade.getNome());
            return cidadeRepository.save(cidade);
        }
    }

    @Override
    public Optional<Cidade> getById(Long id) {
        log.info("Buscando Cidade {}", id);
        return cidadeRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        log.info("Deletando cidade {}", id);
        cidade.ifPresent(cidadeRepository::delete);
    }

    @Override
    public List<Cidade> getListItems() {
        log.info("Buscando cidades");
        return cidadeRepository.findAll();
    }

}
