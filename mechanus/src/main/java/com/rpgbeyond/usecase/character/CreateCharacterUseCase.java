package com.rpgbeyond.usecase.character;

import com.rpgbeyond.model.dto.CreateCharacterRequest;
import com.rpgbeyond.model.entity.Character;
import com.rpgbeyond.service.CharacterService;
import org.springframework.stereotype.Service;

@Service
public class CreateCharacterUseCase {

    private final CharacterService service;

    public CreateCharacterUseCase(CharacterService service) {
        this.service = service;
    }

    public Character execute(CreateCharacterRequest request) {
        return service.create(request);
    }
}
