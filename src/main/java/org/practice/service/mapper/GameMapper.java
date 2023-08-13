package org.practice.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.practice.entity.GameEntity;
import org.practice.service.model.Game;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GameMapper extends BaseMapper<GameEntity, Game>{
    @Override
    @Mapping(target = "developerId", source = "developer.id")
    @Mapping(target = "publisherId", source = "publisher.id")
    Game toDTO(GameEntity gameEntity);
}
