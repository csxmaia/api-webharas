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
public class Video {

    @Id
    @GeneratedValue(strategy= AUTO)
    private Long id;

    @Column
    private String url;

    @ManyToOne
    private Cavalo cavalo;
}
