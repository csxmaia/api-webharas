package com.apiharas.webharas.interfaces;

import com.apiharas.webharas.entity.Linhagem;

import java.util.List;
import java.util.Optional;

public interface LinhagemService {

    Optional<Linhagem> getById(Long id);

    List<Linhagem> getListItems();

    Linhagem save(Linhagem object);

    void remove(Long id);

}
