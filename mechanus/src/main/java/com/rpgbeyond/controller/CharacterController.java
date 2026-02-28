package com.rpgbeyond.controller;

import com.rpgbeyond.model.dto.CreateCharacterRequest;
import com.rpgbeyond.model.dto.CreateCharacterResponse;
import com.rpgbeyond.model.entity.Character;
import com.rpgbeyond.usecase.character.CreateCharacterUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CreateCharacterUseCase createCharacterUseCase;

    public CharacterController(CreateCharacterUseCase createCharacterUseCase) {
        this.createCharacterUseCase = createCharacterUseCase;
    }

    @PostMapping
    public ResponseEntity<CreateCharacterResponse> addCharacter(@RequestBody CreateCharacterRequest request) {
        Character character = createCharacterUseCase.execute(request);

        return ResponseEntity.status(200).body(new CreateCharacterResponse(character.getName(), character.getClassId(),
                character.getBackgroundId(), character.getSpeciesId()));
    }
}
