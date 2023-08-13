package org.practice.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.practice.entity.SubGenreEntity;
import org.practice.service.model.SubGenre;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SubGenreMapper extends BaseMapper<SubGenreEntity, SubGenre> {
}
