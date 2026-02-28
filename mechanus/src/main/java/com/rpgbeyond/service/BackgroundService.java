package com.rpgbeyond.service;

import com.rpgbeyond.model.entity.Background;
import com.rpgbeyond.repository.BackgroundRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackgroundService {

    private final BackgroundRepository repository;

    public BackgroundService(BackgroundRepository repository) {
        this.repository = repository;
    }

    public List<Background> findAll() {
        return repository.findAll();
    }
}
