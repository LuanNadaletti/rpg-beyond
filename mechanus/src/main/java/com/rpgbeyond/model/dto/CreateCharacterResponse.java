package com.rpgbeyond.model.dto;

public record CreateCharacterResponse(String name, Long classId, Long backgroundId, Long speciesId) {
}
