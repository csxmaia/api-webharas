package com.apiharas.webharas.repository;

import com.apiharas.webharas.entity.Ancestrais;
import com.apiharas.webharas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AncestraisRepository extends JpaRepository<Ancestrais, Long> {
}
