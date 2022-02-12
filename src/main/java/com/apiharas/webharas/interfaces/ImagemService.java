package com.apiharas.webharas.interfaces;

import com.apiharas.webharas.entity.Imagem;

import java.util.List;
import java.util.Optional;

public interface ImagemService {

    Optional<Imagem> getById(Long id);

    List<Imagem> getListItems();

    Imagem save(Imagem object);

    void remove(Long id);

}
