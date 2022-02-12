package com.apiharas.webharas.repository;

import com.apiharas.webharas.entity.Estado;
import com.apiharas.webharas.entity.Habilidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabilidadeRepository extends JpaRepository<Habilidade, Long> {
}
