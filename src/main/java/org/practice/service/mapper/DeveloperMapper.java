package org.practice.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.practice.entity.DeveloperEntity;
import org.practice.service.model.Developer;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, uses = GameMapper.class)
public interface DeveloperMapper extends BaseMapper<DeveloperEntity, Developer> {
    @Override
    @Mapping(target = "gameList", source = "gameEntityList")
    Developer toDTO(DeveloperEntity developerEntity);
}
