package org.practice.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import org.practice.entity.GameCodeEntity;
import org.practice.entity.ReceiptDetailsEntity;
import org.practice.entity.ReceiptEntity;
import org.practice.service.model.ReceiptDetails;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-14T07:39:27+0700",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.18 (Oracle Corporation)"
)
@ApplicationScoped
public class ReceiptDetailMapperImpl implements ReceiptDetailMapper {

    @Override
    public List<ReceiptDetails> toDTOList(List<ReceiptDetailsEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ReceiptDetails> list = new ArrayList<ReceiptDetails>( entityList.size() );
        for ( ReceiptDetailsEntity receiptDetailsEntity : entityList ) {
            list.add( toDTO( receiptDetailsEntity ) );
        }

        return list;
    }

    @Override
    public ReceiptDetails toDTO(ReceiptDetailsEntity receiptDetailsEntity) {
        if ( receiptDetailsEntity == null ) {
            return null;
        }

        ReceiptDetails.ReceiptDetailsBuilder receiptDetails = ReceiptDetails.builder();

        receiptDetails.receiptId( receiptDetailsEntityReceiptId( receiptDetailsEntity ) );
        receiptDetails.gameCodeId( receiptDetailsEntityGameCodeId( receiptDetailsEntity ) );
        receiptDetails.id( receiptDetailsEntity.getId() );
        receiptDetails.gamePrice( receiptDetailsEntity.getGamePrice() );

        return receiptDetails.build();
    }

    private Integer receiptDetailsEntityReceiptId(ReceiptDetailsEntity receiptDetailsEntity) {
        if ( receiptDetailsEntity == null ) {
            return null;
        }
        ReceiptEntity receipt = receiptDetailsEntity.getReceipt();
        if ( receipt == null ) {
            return null;
        }
        Integer id = receipt.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer receiptDetailsEntityGameCodeId(ReceiptDetailsEntity receiptDetailsEntity) {
        if ( receiptDetailsEntity == null ) {
            return null;
        }
        GameCodeEntity gameCode = receiptDetailsEntity.getGameCode();
        if ( gameCode == null ) {
            return null;
        }
        Integer id = gameCode.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
