package com.apiharas.webharas.repository;

import com.apiharas.webharas.entity.Imagem;
import com.apiharas.webharas.entity.Linhagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinhagemRepository extends JpaRepository<Linhagem, Long> {
}
