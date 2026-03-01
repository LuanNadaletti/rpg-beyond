package com.rpgbeyond.mapper;

import com.rpgbeyond.model.dto.CreateCharacterRequest;
import com.rpgbeyond.model.entity.Character;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CharacterMapper {

    CharacterMapper INSTANCE = Mappers.getMapper(CharacterMapper.class);

    Character createCharacterRequestToCharacter(CreateCharacterRequest request);
}
