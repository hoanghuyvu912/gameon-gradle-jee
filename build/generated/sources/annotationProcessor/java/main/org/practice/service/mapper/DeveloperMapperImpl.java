package org.practice.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.practice.entity.DeveloperEntity;
import org.practice.service.model.Developer;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-12T18:14:41+0700",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.18 (Oracle Corporation)"
)
@ApplicationScoped
public class DeveloperMapperImpl implements DeveloperMapper {

    @Inject
    private GameMapper gameMapper;

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

    @Override
    public Developer toDTO(DeveloperEntity developerEntity) {
        if ( developerEntity == null ) {
            return null;
        }

        Developer.DeveloperBuilder developer = Developer.builder();

        developer.gameList( gameMapper.toDTOList( developerEntity.getGameEntityList() ) );
        developer.id( developerEntity.getId() );
        developer.name( developerEntity.getName() );
        developer.thumbnail( developerEntity.getThumbnail() );
        developer.coverPhoto( developerEntity.getCoverPhoto() );
        developer.description( developerEntity.getDescription() );
        developer.establishedDate( developerEntity.getEstablishedDate() );

        return developer.build();
    }
}
