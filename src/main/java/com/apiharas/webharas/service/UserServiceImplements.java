package com.apiharas.webharas.service;

import com.apiharas.webharas.entity.Role;
import com.apiharas.webharas.entity.User;
import com.apiharas.webharas.repository.RoleRepository;
import com.apiharas.webharas.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImplements implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            log.error("User não encontrado no banco de dados");
            throw new UsernameNotFoundException("User não encontrado no banco de dados");
        }else{
            log.info("User encontrado no banco de dados: {} ", username);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(r -> {
            authorities.add(new SimpleGrantedAuthority(r.getNome()));
        });

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public User saveUser(User user) {
        log.info("Salvando novo usuário {} no banco de dados", user.getNome());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Salvando novo papel {} no banco de dados", role.getNome());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        log.info("Adicionando papel {} para usuário {}", roleName, userName);
        User user = userRepository.findByUsername(userName);
        Role role = roleRepository.findByNome(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String userName) {
        log.info("Buscando usuário {}",userName);
        return userRepository.findByUsername(userName);
    }

    @Override
    public List<User> getUsers() {
        log.info("Buscando usuários");
        return userRepository.findAll();
    }
}
