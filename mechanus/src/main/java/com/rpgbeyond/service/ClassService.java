package com.rpgbeyond.service;

import com.rpgbeyond.model.entity.Class;
import com.rpgbeyond.repository.ClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    private final ClassRepository repository;

    public ClassService(ClassRepository repository) {
        this.repository = repository;
    }

    public List<Class> getAll() {
        return repository.findAll();
    }
}
