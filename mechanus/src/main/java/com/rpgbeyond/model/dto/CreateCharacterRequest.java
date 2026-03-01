package com.rpgbeyond.model.dto;

public record CreateCharacterRequest(
        String name,
        Long classId,
        Long backgroundId,
        Long speciesId,
        int strength,
        int dexterity,
        int constitution,
        int intelligence,
        int wisdom,
        int charisma
) {
}
