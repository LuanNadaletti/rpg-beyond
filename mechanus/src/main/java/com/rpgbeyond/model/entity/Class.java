package com.rpgbeyond.model.entity;

import jakarta.persistence.*;

@Entity
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private String name;
}
