package org.practice.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import org.practice.entity.GenreEntity;
import org.practice.service.model.Genre;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-04T20:45:43+0700",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.18 (Oracle Corporation)"
)
@ApplicationScoped
public class GenreMapperImpl implements GenreMapper {

    @Override
    public Genre toDTO(GenreEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Genre.GenreBuilder genre = Genre.builder();

        genre.id( entity.getId() );
        genre.name( entity.getName() );

        return genre.build();
    }

    @Override
    public List<Genre> toDTOList(List<GenreEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<Genre> list = new ArrayList<Genre>( entityList.size() );
        for ( GenreEntity genreEntity : entityList ) {
            list.add( toDTO( genreEntity ) );
        }

        return list;
    }
}
