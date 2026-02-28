package com.rpgbeyond.model.entity;

import jakarta.persistence.*;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(name = "uk_background_name", columnNames = "name")
)
public class Background {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 120)
    private String name;

    public Background() {
    }

    public Background(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
