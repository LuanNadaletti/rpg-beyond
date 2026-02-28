package com.rpgbeyond.service;

import com.rpgbeyond.model.dto.CreateCharacterRequest;
import com.rpgbeyond.model.entity.Character;
import com.rpgbeyond.repository.CharacterRepository;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    private final CharacterRepository repository;

    public CharacterService(CharacterRepository repository) {
        this.repository = repository;
    }

    public Character create(CreateCharacterRequest request) {
        Character character = new Character(request.name(), request.classId(), request.backgroundId(), request.speciesId());

        return repository.save(character);
    }
}
