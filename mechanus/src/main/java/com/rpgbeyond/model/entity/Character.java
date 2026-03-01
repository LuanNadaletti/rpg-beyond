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

    public void setName(String name) {
        this.name = name;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public void setBackgroundId(long backgroundId) {
        this.backgroundId = backgroundId;
    }

    public void setSpeciesId(long speciesId) {
        this.speciesId = speciesId;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }
}
