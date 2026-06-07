package com.joaog4briel.ninjas.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    @OneToMany(mappedBy = "missoes") //Uma missão pode ter vários ninjas
    private List<NinjaEntity> ninjas;

}
