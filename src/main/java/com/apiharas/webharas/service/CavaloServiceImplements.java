package com.apiharas.webharas.service;

import com.apiharas.webharas.entity.Cavalo;
import com.apiharas.webharas.entity.User;
import com.apiharas.webharas.interfaces.CavaloService;
import com.apiharas.webharas.repository.CavaloRepository;
import com.apiharas.webharas.repository.ImagemRepository;
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
    private final ImagemRepository imagemRepository;
    private final UserRepository userRepository;

    @Override
    public Cavalo saveCavalo(Cavalo cavalo, String authorizationHeader) {
        User user = getUser(authorizationHeader);
        cavalo.setUser(user);
        if (cavalo.getId() == null) {
            Cavalo cavaloSaved = cavaloRepository.save(cavalo);
            cavaloSaved.getImagens().forEach(imagem -> {
                imagem.setCavalo(cavaloSaved);
            });
            imagemRepository.saveAll(cavaloSaved.getImagens());
            return cavaloSaved;
        } else {
            Cavalo cavaloSaved = cavaloRepository.save(cavalo);
            cavaloSaved.getImagens().forEach(imagem -> {
                imagem.setCavalo(cavaloSaved);
            });
            imagemRepository.saveAll(cavaloSaved.getImagens());
            return cavaloSaved;
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
        User user = getUser(authorizationHeader);
        List<Cavalo> cavalos = cavaloRepository.findByUserId(user.getId());
        return cavalos;
    }

    private User getUser(String authorizationHeader) {
        String refresh_token = authorizationHeader.substring("Bearer ".length());
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(refresh_token);
        String username = decodedJWT.getSubject();
        User user = userRepository.findByUsername(username).get();
        return user;
    }

}
