package com.rpgbeyond.controller;

import com.rpgbeyond.model.entity.Class;
import com.rpgbeyond.service.ClassService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {

    private final ClassService service;

    public ClassController(ClassService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Class>> getClasses() {
        return ResponseEntity.ok(service.getAll());
    }
}
