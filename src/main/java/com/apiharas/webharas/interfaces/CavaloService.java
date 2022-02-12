package com.apiharas.webharas.interfaces;

import com.apiharas.webharas.entity.Cavalo;

import java.util.List;
import java.util.Optional;

public interface CavaloService {

    Cavalo saveCavalo(Cavalo cavalo);
    Optional<Cavalo> getCavaloById(Long idCavalo);
    void removeCavalo(Long cavalo);
    List<Cavalo> getCavalos();
}
