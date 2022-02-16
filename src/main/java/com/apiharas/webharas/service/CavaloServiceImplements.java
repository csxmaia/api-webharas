package com.apiharas.webharas.service;

import com.apiharas.webharas.entity.Cavalo;
import com.apiharas.webharas.entity.User;
import com.apiharas.webharas.interfaces.CavaloService;
import com.apiharas.webharas.repository.CavaloRepository;
import com.apiharas.webharas.repository.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CavaloServiceImplements implements CavaloService {
    private final CavaloRepository cavaloRepository;
    private final UserRepository userRepository;

    @Override
    public Cavalo saveCavalo(Cavalo cavalo) {
        if (cavalo.getId() == null) {
            log.info("Salvando novo cavalo {} no banco de dados", cavalo.getNome());
            return cavaloRepository.save(cavalo);
        } else {
            log.info("Atualizando Estado {} no banco de dados", cavalo.getNome());
            return cavaloRepository.save(cavalo);
        }
    }

    @Override
    public Optional<Cavalo> getCavaloById(Long cavalo) {
        log.info("Buscando cavalo {}", cavalo);
        return cavaloRepository.findById(cavalo);
    }

    @Override
    public void removeCavalo(Long idCavalo) {
        Optional<Cavalo> cavalo = cavaloRepository.findById(idCavalo);
        log.info("Deletando cavalo {}", idCavalo);
        cavalo.ifPresent(cavaloRepository::delete);
    }

    @Override
    public List<Cavalo> getCavalos() {
        log.info("Buscando cavalos");
        return cavaloRepository.findAll();
    }

    @Override
    public List<Cavalo> getCavalos(Long cidade, Long genero, Long raca, Long pelagem) {
        log.info("Buscando cavalos");
        return cavaloRepository.findByFilterParams(cidade, genero, raca, pelagem);
    }

    @Override
    public List<Cavalo> getCavalosByUser(String authorizationHeader) {
        String refresh_token = authorizationHeader.substring("Bearer ".length());
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(refresh_token);
        String username = decodedJWT.getSubject();
        User user = getUser(username);
        List<Cavalo> cavalos = cavaloRepository.findByUserId(user.getId());
        return cavalos;
    }

    private User getUser(String userName) {
        return userRepository.findByUsername(userName).get();
    }

}
