package org.practice.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import org.practice.entity.DeveloperEntity;
import org.practice.service.model.Developer;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-10T18:46:28+0700",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.18 (Oracle Corporation)"
)
@ApplicationScoped
public class DeveloperMapperImpl implements DeveloperMapper {

    @Override
    public Developer toDTO(DeveloperEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Developer.DeveloperBuilder developer = Developer.builder();

        developer.id( entity.getId() );
        developer.name( entity.getName() );
        developer.thumbnail( entity.getThumbnail() );
        developer.coverPhoto( entity.getCoverPhoto() );
        developer.description( entity.getDescription() );
        developer.establishedDate( entity.getEstablishedDate() );

        return developer.build();
    }

    @Override
    public List<Developer> toDTOList(List<DeveloperEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<Developer> list = new ArrayList<Developer>( entityList.size() );
        for ( DeveloperEntity developerEntity : entityList ) {
            list.add( toDTO( developerEntity ) );
        }

        return list;
    }
}
