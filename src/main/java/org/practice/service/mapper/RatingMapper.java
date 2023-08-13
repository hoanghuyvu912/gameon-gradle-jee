package org.practice.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.practice.entity.RatingEntity;
import org.practice.service.model.Rating;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RatingMapper extends BaseMapper<RatingEntity, Rating> {
    @Override
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "gameId", source = "game.id")
    Rating toDTO(RatingEntity ratingEntity);
}
