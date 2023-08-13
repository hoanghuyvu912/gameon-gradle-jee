package org.practice.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.practice.entity.ReceiptDetailsEntity;
import org.practice.service.model.ReceiptDetails;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, uses = GameMapper.class)
public interface ReceiptDetailMapper extends BaseMapper<ReceiptDetailsEntity, ReceiptDetails> {
    @Override
    @Mapping(target = "receiptId", source = "receipt.id")
    @Mapping(target = "gameCodeId", source = "gameCode.id")
    ReceiptDetails toDTO(ReceiptDetailsEntity receiptDetailsEntity);
}
