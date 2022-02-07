package com.apiharas.webharas.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="pelagem")
public class Pelagem {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;
}
