package com.rpgbeyond.service;

import com.rpgbeyond.mapper.CharacterMapper;
import com.rpgbeyond.model.dto.CreateCharacterRequest;
import com.rpgbeyond.model.entity.Character;
import com.rpgbeyond.repository.CharacterRepository;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    private final CharacterRepository repository;
    private final CharacterMapper mapper;

    public CharacterService(CharacterRepository repository, CharacterMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Character create(CreateCharacterRequest request) {
        Character character = mapper.createCharacterRequestToCharacter(request);

        return repository.save(character);
    }
}
