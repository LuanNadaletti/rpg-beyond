package com.rpgbeyond.repository;

import com.rpgbeyond.model.entity.Background;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BackgroundRepository extends JpaRepository<Background, Long> {
    boolean existsByNameIgnoreCase(String name);
}
