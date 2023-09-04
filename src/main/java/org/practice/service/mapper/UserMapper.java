package org.practice.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.practice.entity.UserEntity;
import org.practice.service.model.User;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

public interface UserMapper extends BaseMapper<UserEntity, User>{

}
