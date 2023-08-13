package org.practice.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.practice.entity.GameImageEntity;
import org.practice.service.model.GameImage;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GameImageMapper extends BaseMapper<GameImageEntity, GameImage> {
    @Override
    @Mapping(target = "gameId", source = "game.id")
    GameImage toDTO(GameImageEntity gameImageEntity);
}
