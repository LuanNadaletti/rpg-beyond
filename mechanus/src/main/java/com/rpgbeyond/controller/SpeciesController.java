package com.rpgbeyond.controller;

import com.rpgbeyond.model.entity.Species;
import com.rpgbeyond.service.SpeciesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/species")
public class SpeciesController {

    private final SpeciesService service;

    public SpeciesController(SpeciesService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Species>> getSpecies() {
        return ResponseEntity.ok(service.findAll());
    }
}
