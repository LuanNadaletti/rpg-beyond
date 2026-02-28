package com.rpgbeyond.repository;

import com.rpgbeyond.model.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<Species, Long> {
    boolean existsByNameIgnoreCase(String name);
}
