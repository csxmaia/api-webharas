package com.apiharas.webharas.repository;

import com.apiharas.webharas.entity.Haras;
import com.apiharas.webharas.entity.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagemRepository extends JpaRepository<Imagem, Long> {
}
