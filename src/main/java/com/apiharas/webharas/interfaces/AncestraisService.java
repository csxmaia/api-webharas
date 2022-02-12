package com.apiharas.webharas.interfaces;

import com.apiharas.webharas.entity.Ancestrais;
import com.apiharas.webharas.entity.Estado;

import java.util.List;
import java.util.Optional;

public interface AncestraisService {

    Optional<Ancestrais> getById(Long id);
    List<Ancestrais> getListItems();
    Ancestrais save(Ancestrais object);
    void remove(Long id);

}
