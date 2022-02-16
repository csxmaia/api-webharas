package com.apiharas.webharas.repository;

import com.apiharas.webharas.entity.Cavalo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CavaloRepository extends JpaRepository<Cavalo, Long> {

    @Query(value = "SELECT cav.* FROM cavalo cav " +
        "INNER JOIN cidade as cid ON cid.id = cav.cidade_id " +
        "INNER JOIN genero as gen ON gen.id = cav.genero_id " +
        "INNER JOIN raca as rac ON rac.id = cav.raca_id " +
        "INNER JOIN pelagem as pel ON pel.id = cav.pelagem_id " +
        "WHERE (:cidadeId is null or cid.id = :cidadeId) " +
        "AND (:generoId is null or gen.id = :generoId) " +
        "AND (:racaId is null or rac.id = :racaId) " +
        "AND (:pelagemId is null or pel.id = :pelagemId);",
        nativeQuery = true
    )
    List<Cavalo> findByFilterParams(
        @Param("cidadeId") Long cidadeid,
        @Param("generoId") Long generoId,
        @Param("racaId") Long racaId,
        @Param("pelagemId") Long pelagemId
    );

    List<Cavalo> findByUserId(Long id);
}
