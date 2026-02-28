package com.rpgbeyond.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "class", referencedColumnName = "id")
    private Class clazz;

    private int strength;

    private int dexterity;

    private int constitution;

    private int intelligence;

    private int wisdom;

    private int charisma;
}
