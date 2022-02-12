package com.apiharas.webharas.repository;

import com.apiharas.webharas.entity.Habilidade;
import com.apiharas.webharas.entity.Haras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HarasRepository extends JpaRepository<Haras, Long> {
}
