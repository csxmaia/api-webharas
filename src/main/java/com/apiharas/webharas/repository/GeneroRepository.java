package com.apiharas.webharas.repository;

import com.apiharas.webharas.entity.Estado;
import com.apiharas.webharas.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
}
