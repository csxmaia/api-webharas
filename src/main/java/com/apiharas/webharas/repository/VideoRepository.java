package com.apiharas.webharas.repository;

import com.apiharas.webharas.entity.Raca;
import com.apiharas.webharas.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
