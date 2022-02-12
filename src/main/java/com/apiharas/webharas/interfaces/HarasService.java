package com.apiharas.webharas.interfaces;

import com.apiharas.webharas.entity.Haras;

import java.util.List;
import java.util.Optional;

public interface HarasService {

    Optional<Haras> getById(Long id);

    List<Haras> getListItems();

    Haras save(Haras object);

    void remove(Long id);

}
