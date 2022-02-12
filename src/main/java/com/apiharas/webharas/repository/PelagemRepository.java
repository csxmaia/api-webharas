package com.apiharas.webharas.repository;

import com.apiharas.webharas.entity.Linhagem;
import com.apiharas.webharas.entity.Pelagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PelagemRepository extends JpaRepository<Pelagem, Long> {
}
