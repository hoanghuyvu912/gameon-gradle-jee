package org.practice.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.practice.entity.CommentEntity;
import org.practice.service.model.Comment;

import java.util.List;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, uses = GameMapper.class)
public interface CommentMapper extends BaseMapper<CommentEntity, Comment> {
    @Override
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "gameId", source = "game.id")
    Comment toDTO(CommentEntity commentEntity);
}
