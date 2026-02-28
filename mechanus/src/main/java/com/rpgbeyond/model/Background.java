package com.rpgbeyond.model;

import jakarta.persistence.*;

@Entity
public class Background {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;
}
