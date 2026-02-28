package com.rpgbeyond.model.dto;

public record CreateCharacterRequest(String name, Long classId, Long backgroundId, Long speciesId) {
}
