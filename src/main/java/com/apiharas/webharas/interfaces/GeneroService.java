package com.apiharas.webharas.interfaces;

import com.apiharas.webharas.entity.Cidade;
import com.apiharas.webharas.entity.Genero;

import java.util.List;
import java.util.Optional;

public interface GeneroService {

    Optional<Genero> getById(Long id);

    List<Genero> getListItems();

    Genero save(Genero object);

    void remove(Long id);

}
