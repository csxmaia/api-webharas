package com.apiharas.webharas.interfaces;

import com.apiharas.webharas.entity.Habilidade;

import java.util.List;
import java.util.Optional;

public interface HabilidadeService {

    Optional<Habilidade> getById(Long id);

    List<Habilidade> getListItems();

    Habilidade save(Habilidade object);

    void remove(Long id);

}
