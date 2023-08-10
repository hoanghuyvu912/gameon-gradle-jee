package org.practice.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.practice.entity.DeveloperEntity;
import org.practice.service.model.Developer;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DeveloperMapper extends BaseMapper<DeveloperEntity, Developer>{
}
