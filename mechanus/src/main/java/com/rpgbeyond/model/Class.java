package com.rpgbeyond.model;

import jakarta.persistence.*;

@Entity
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false)
    private String name;
}
