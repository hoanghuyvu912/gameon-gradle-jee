package org.practice.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import org.practice.entity.GameEntity;
import org.practice.entity.GameImageEntity;
import org.practice.service.model.GameImage;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-16T16:33:00+0700",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.18 (Oracle Corporation)"
)
@ApplicationScoped
public class GameImageMapperImpl implements GameImageMapper {

    @Override
    public List<GameImage> toDTOList(List<GameImageEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<GameImage> list = new ArrayList<GameImage>( entityList.size() );
        for ( GameImageEntity gameImageEntity : entityList ) {
            list.add( toDTO( gameImageEntity ) );
        }

        return list;
    }

    @Override
    public GameImage toDTO(GameImageEntity gameImageEntity) {
        if ( gameImageEntity == null ) {
            return null;
        }

        GameImage.GameImageBuilder gameImage = GameImage.builder();

        gameImage.gameId( gameImageEntityGameId( gameImageEntity ) );
        gameImage.id( gameImageEntity.getId() );
        gameImage.imageLink( gameImageEntity.getImageLink() );

        return gameImage.build();
    }

    private Integer gameImageEntityGameId(GameImageEntity gameImageEntity) {
        if ( gameImageEntity == null ) {
            return null;
        }
        GameEntity game = gameImageEntity.getGame();
        if ( game == null ) {
            return null;
        }
        Integer id = game.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
