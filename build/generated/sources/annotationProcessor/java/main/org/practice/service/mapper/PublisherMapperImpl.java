package org.practice.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import org.practice.entity.GameEntity;
import org.practice.entity.PublisherEntity;
import org.practice.service.model.Game;
import org.practice.service.model.Publisher;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-07T19:19:56+0700",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.18 (Oracle Corporation)"
)
@ApplicationScoped
public class PublisherMapperImpl implements PublisherMapper {

    @Override
    public List<Publisher> toDTOList(List<PublisherEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<Publisher> list = new ArrayList<Publisher>( entityList.size() );
        for ( PublisherEntity publisherEntity : entityList ) {
            list.add( toDTO( publisherEntity ) );
        }

        return list;
    }

    @Override
    public Publisher toDTO(PublisherEntity publisherEntity) {
        if ( publisherEntity == null ) {
            return null;
        }

        Publisher.PublisherBuilder publisher = Publisher.builder();

        publisher.gameList( gameEntityListToGameList( publisherEntity.getGameEntityList() ) );
        publisher.id( publisherEntity.getId() );
        publisher.name( publisherEntity.getName() );
        publisher.thumbnail( publisherEntity.getThumbnail() );
        publisher.coverPhoto( publisherEntity.getCoverPhoto() );
        publisher.description( publisherEntity.getDescription() );
        publisher.establishedDate( publisherEntity.getEstablishedDate() );

        return publisher.build();
    }

    protected Game gameEntityToGame(GameEntity gameEntity) {
        if ( gameEntity == null ) {
            return null;
        }

        Game.GameBuilder game = Game.builder();

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

    protected List<Game> gameEntityListToGameList(List<GameEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Game> list1 = new ArrayList<Game>( list.size() );
        for ( GameEntity gameEntity : list ) {
            list1.add( gameEntityToGame( gameEntity ) );
        }

        return list1;
    }
}
