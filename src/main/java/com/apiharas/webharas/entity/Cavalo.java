package com.apiharas.webharas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cavalo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double preco;

    @ManyToOne
    private Genero genero;

    @ManyToOne
    private Habilidade habilidade;

    @Column(nullable = false)
    private Date data_nascimento;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    private Cidade cidade;

    @ManyToOne
    private User user;

    @ManyToOne
    private Linhagem linhagem;

    @ManyToOne
    private Haras haras;

    @ManyToOne
    private Raca raca;

    @ManyToOne
    private Pelagem pelagem;

    @Column(nullable = false)
    private Boolean vendido;

}
