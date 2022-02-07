package com.apiharas.webharas.entity;

import lombok.Data;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="cavalo")
public class Cavalo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String preco;

    @Column(nullable = false)
    private Date dtnasc;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Long genero_id;

    @Column(nullable = false)
    private Long habilidade_id;

    @Column(nullable = false)
    private Long video_id;

    @Column(nullable = false)
    private Long cidade_id;

    @Column(nullable = false)
    private Long usuario_id;

    @Column(nullable = false)
    private Long linhagem_id;

    @Column(nullable = false)
    private Long haras_id;

    @Column(nullable = false)
    private Long raca_id;

    @Column(nullable = false)
    private Long pelagem_id;

    @Column(nullable = false)
    private Boolean vendido;

}
