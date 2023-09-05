package org.practice.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import org.practice.entity.ReceiptEntity;
import org.practice.entity.UserEntity;
import org.practice.service.model.Receipt;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-31T09:56:12+0700",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.18 (Oracle Corporation)"
)
@ApplicationScoped
public class ReceiptMapperImpl implements ReceiptMapper {

    @Override
    public List<Receipt> toDTOList(List<ReceiptEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<Receipt> list = new ArrayList<Receipt>( entityList.size() );
        for ( ReceiptEntity receiptEntity : entityList ) {
            list.add( toDTO( receiptEntity ) );
        }

        return list;
    }

    @Override
    public Receipt toDTO(ReceiptEntity receiptEntity) {
        if ( receiptEntity == null ) {
            return null;
        }

        Receipt.ReceiptBuilder receipt = Receipt.builder();

        receipt.userId( receiptEntityUserId( receiptEntity ) );
        receipt.id( receiptEntity.getId() );
        receipt.receiptDate( receiptEntity.getReceiptDate() );

        return receipt.build();
    }

    private Integer receiptEntityUserId(ReceiptEntity receiptEntity) {
        if ( receiptEntity == null ) {
            return null;
        }
        UserEntity user = receiptEntity.getUser();
        if ( user == null ) {
            return null;
        }
        Integer id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
