package com.apiharas.webharas.repository;

import com.apiharas.webharas.entity.Ancestrais;
import com.apiharas.webharas.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
