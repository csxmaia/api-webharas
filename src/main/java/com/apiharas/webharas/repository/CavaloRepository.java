package com.apiharas.webharas.repository;

import com.apiharas.webharas.entity.Cavalo;
import com.apiharas.webharas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CavaloRepository extends JpaRepository<Cavalo, Long> {
}
