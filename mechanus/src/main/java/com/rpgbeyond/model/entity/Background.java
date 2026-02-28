package com.rpgbeyond.model.entity;

import jakarta.persistence.*;

@Entity
public class Background {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;
}
