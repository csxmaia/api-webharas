package com.apiharas.webharas.interfaces;

import com.apiharas.webharas.entity.Cavalo;

import java.util.List;
import java.util.Optional;

public interface CavaloService {

    Cavalo saveCavalo(Cavalo cavalo, String authorizationHeader);
    Optional<Cavalo> getCavaloById(Long idCavalo);
    void removeCavalo(Long cavalo);
    List<Cavalo> getCavalos();
    List<Cavalo> getCavalos(Long cidade, Long genero, Long raca, Long pelagem);
    List<Cavalo> getCavalosByUser(String authorizationHeader);
}
