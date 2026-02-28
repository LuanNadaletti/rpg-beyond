package com.rpgbeyond.model.entity;

import jakarta.persistence.*;

@Entity
public class Species {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;
}
