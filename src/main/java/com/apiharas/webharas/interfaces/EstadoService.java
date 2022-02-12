package com.apiharas.webharas.interfaces;

import com.apiharas.webharas.entity.Cavalo;
import com.apiharas.webharas.entity.Estado;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface EstadoService {

    Optional<Estado> getById(Long id);
    List<Estado> getListItems();
    Estado save(Estado object);
    void remove(Long id);

}
