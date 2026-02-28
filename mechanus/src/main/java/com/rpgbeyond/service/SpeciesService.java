package com.rpgbeyond.service;

import com.rpgbeyond.model.entity.Species;
import com.rpgbeyond.repository.SpeciesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeciesService {

    private final SpeciesRepository repository;

    public SpeciesService(SpeciesRepository repository) {
        this.repository = repository;
    }

    public List<Species> findAll() {
        return repository.findAll();
    }
}
