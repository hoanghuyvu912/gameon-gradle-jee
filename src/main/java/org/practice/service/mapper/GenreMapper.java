package org.practice.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.practice.entity.GenreEntity;
import org.practice.service.model.Genre;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GenreMapper extends BaseMapper<GenreEntity, Genre> {
}
