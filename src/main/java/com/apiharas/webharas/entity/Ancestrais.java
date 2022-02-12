package com.apiharas.webharas.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ancestrais {

    @Id
    @GeneratedValue(strategy= AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column
    private Long ancestrais_mae_id;

    @Column
    private Long ancestrais_pai_id;

    @OneToOne
    private Linhagem linhagem;

}
