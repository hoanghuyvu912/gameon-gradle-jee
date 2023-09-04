package org.practice.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import org.practice.entity.SubGenreEntity;
import org.practice.service.model.SubGenre;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-04T20:45:43+0700",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.18 (Oracle Corporation)"
)
@ApplicationScoped
public class SubGenreMapperImpl implements SubGenreMapper {

    @Override
    public SubGenre toDTO(SubGenreEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SubGenre.SubGenreBuilder subGenre = SubGenre.builder();

        subGenre.id( entity.getId() );
        subGenre.name( entity.getName() );

        return subGenre.build();
    }

    @Override
    public List<SubGenre> toDTOList(List<SubGenreEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<SubGenre> list = new ArrayList<SubGenre>( entityList.size() );
        for ( SubGenreEntity subGenreEntity : entityList ) {
            list.add( toDTO( subGenreEntity ) );
        }

        return list;
    }
}
