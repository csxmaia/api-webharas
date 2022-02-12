package com.apiharas.webharas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Linhagem {

    @Id
    @GeneratedValue(strategy= AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ancestrais_mae_id", referencedColumnName = "ancestrais_mae_id")
    private Ancestrais ancestrais_mae_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ancestrais_pai_id", referencedColumnName = "ancestrais_pai_id")
    private Ancestrais ancestrais_pai_id;
}
