package com.apiharas.webharas.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="cidade")
public class Cidade {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Long estado_id;
}
