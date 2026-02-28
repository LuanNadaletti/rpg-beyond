package com.rpgbeyond.controller;

import com.rpgbeyond.model.entity.Background;
import com.rpgbeyond.service.BackgroundService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/backgrounds")
public class BackgroundController {

    private final BackgroundService service;

    public BackgroundController(BackgroundService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Background>> getBackgrounds() {
        return ResponseEntity.ok(service.findAll());
    }
}
