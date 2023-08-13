package org.practice.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.practice.entity.DeveloperEntity;
import org.practice.entity.GameEntity;
import org.practice.entity.GameImageEntity;
import org.practice.entity.PublisherEntity;
import org.practice.service.model.Game;
import org.practice.service.model.GameImage;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-14T00:48:17+0700",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.18 (Oracle Corporation)"
)
@ApplicationScoped
public class GameMapperImpl implements GameMapper {

    @Inject
    private CommentMapper commentMapper;
    @Inject
    private RatingMapper ratingMapper;

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
        game.commentList( commentMapper.toDTOList( gameEntity.getCommentEntityList() ) );
        game.ratingList( ratingMapper.toDTOList( gameEntity.getRatingEntityList() ) );
        game.gameImageList( gameImageEntityListToGameImageList( gameEntity.getGameImageEntityList() ) );
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

    protected GameImage gameImageEntityToGameImage(GameImageEntity gameImageEntity) {
        if ( gameImageEntity == null ) {
            return null;
        }

        GameImage.GameImageBuilder gameImage = GameImage.builder();

        gameImage.id( gameImageEntity.getId() );
        gameImage.imageLink( gameImageEntity.getImageLink() );

        return gameImage.build();
    }

    protected List<GameImage> gameImageEntityListToGameImageList(List<GameImageEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<GameImage> list1 = new ArrayList<GameImage>( list.size() );
        for ( GameImageEntity gameImageEntity : list ) {
            list1.add( gameImageEntityToGameImage( gameImageEntity ) );
        }

        return list1;
    }
}
