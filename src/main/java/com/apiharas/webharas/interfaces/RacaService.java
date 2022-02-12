package com.apiharas.webharas.interfaces;

import com.apiharas.webharas.entity.Raca;

import java.util.List;
import java.util.Optional;

public interface RacaService {

    Optional<Raca> getById(Long id);

    List<Raca> getListItems();

    Raca save(Raca object);

    void remove(Long id);

}
