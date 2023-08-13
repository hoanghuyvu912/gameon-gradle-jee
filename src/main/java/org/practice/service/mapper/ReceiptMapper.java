package org.practice.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.practice.entity.ReceiptEntity;
import org.practice.service.model.Receipt;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, uses = GameMapper.class)
public interface ReceiptMapper extends BaseMapper<ReceiptEntity, Receipt> {
    @Override
    @Mapping(target = "userId", source = "user.id")
    Receipt toDTO(ReceiptEntity receiptEntity);
}
