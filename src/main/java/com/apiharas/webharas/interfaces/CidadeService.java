package com.apiharas.webharas.interfaces;

import com.apiharas.webharas.entity.Cidade;
import com.apiharas.webharas.entity.Estado;

import java.util.List;
import java.util.Optional;

public interface CidadeService {

    Optional<Cidade> getById(Long id);
    List<Cidade> getListItems();
    Cidade save(Cidade object);
    void remove(Long id);

}
