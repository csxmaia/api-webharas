package com.apiharas.webharas.repository;

import com.apiharas.webharas.entity.Role;
import com.apiharas.webharas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByNome(String nome);
}
