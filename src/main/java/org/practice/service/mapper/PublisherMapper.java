package org.practice.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.practice.entity.DeveloperEntity;
import org.practice.entity.PublisherEntity;
import org.practice.service.model.Developer;
import org.practice.service.model.Publisher;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PublisherMapper extends BaseMapper<PublisherEntity, Publisher>{
    @Override
    @Mapping(target = "gameList", source = "gameEntityList")
    Publisher toDTO(PublisherEntity publisherEntity);
}
