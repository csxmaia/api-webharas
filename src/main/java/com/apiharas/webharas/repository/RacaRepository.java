package com.apiharas.webharas.repository;

import com.apiharas.webharas.entity.Pelagem;
import com.apiharas.webharas.entity.Raca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RacaRepository extends JpaRepository<Raca, Long> {
}
