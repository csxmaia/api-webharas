package com.apiharas.webharas.interfaces;

import com.apiharas.webharas.entity.Pelagem;

import java.util.List;
import java.util.Optional;

public interface PelagemService {

    Optional<Pelagem> getById(Long id);

    List<Pelagem> getListItems();

    Pelagem save(Pelagem object);

    void remove(Long id);

}
