package com.apiharas.webharas.repository;

import com.apiharas.webharas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
