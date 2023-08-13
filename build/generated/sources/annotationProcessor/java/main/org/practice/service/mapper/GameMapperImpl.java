package org.practice.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import org.practice.entity.DeveloperEntity;
import org.practice.entity.GameEntity;
import org.practice.entity.PublisherEntity;
import org.practice.service.model.Game;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-13T11:18:44+0700",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.18 (Oracle Corporation)"
)
@ApplicationScoped
public class GameMapperImpl implements GameMapper {

    @Override
    public List<Game> toDTOList(List<GameEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<Game> list = new ArrayList<Game>( entityList.size() );
        for ( GameEntity gameEntity : entityList ) {
            list.add( toDTO( gameEntity ) );
        }

        return list;
    }

    @Override
    public Game toDTO(GameEntity gameEntity) {
        if ( gameEntity == null ) {
            return null;
        }

        Game.GameBuilder game = Game.builder();

        game.developerId( gameEntityDeveloperId( gameEntity ) );
        game.publisherId( gameEntityPublisherId( gameEntity ) );
        game.id( gameEntity.getId() );
        game.name( gameEntity.getName() );
        game.thumbnail( gameEntity.getThumbnail() );
        game.description( gameEntity.getDescription() );
        game.trailer( gameEntity.getTrailer() );
        game.releasedDate( gameEntity.getReleasedDate() );
        game.systemReq( gameEntity.getSystemReq() );
        game.price( gameEntity.getPrice() );

        return game.build();
    }

    private Integer gameEntityDeveloperId(GameEntity gameEntity) {
        if ( gameEntity == null ) {
            return null;
        }
        DeveloperEntity developer = gameEntity.getDeveloper();
        if ( developer == null ) {
            return null;
        }
        Integer id = developer.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer gameEntityPublisherId(GameEntity gameEntity) {
        if ( gameEntity == null ) {
            return null;
        }
        PublisherEntity publisher = gameEntity.getPublisher();
        if ( publisher == null ) {
            return null;
        }
        Integer id = publisher.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
