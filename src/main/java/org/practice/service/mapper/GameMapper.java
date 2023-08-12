package org.practice.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.practice.entity.GameEntity;
import org.practice.service.model.Game;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GameMapper extends BaseMapper<GameEntity, Game>{
}
