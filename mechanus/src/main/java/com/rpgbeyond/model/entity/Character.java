package com.rpgbeyond.model.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Character implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    private long classId;

    private long backgroundId;

    private long speciesId;

    private int strength = 0;

    private int dexterity = 0;

    private int constitution = 0;

    private int intelligence = 0;

    private int wisdom = 0;

    private int charisma = 0;

    public Character() {
    }

    public Character(String name, long classId, long backgroundId, long speciesId) {
        this.name = name;
        this.classId = classId;
        this.backgroundId = backgroundId;
        this.speciesId = speciesId;
    }

    public String getName() {
        return name;
    }

    public long getClassId() {
        return classId;
    }

    public long getBackgroundId() {
        return backgroundId;
    }

    public long getSpeciesId() {
        return speciesId;
    }
}
