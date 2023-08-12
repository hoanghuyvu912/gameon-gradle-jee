package org.practice.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import org.practice.entity.GameEntity;
import org.practice.service.model.Game;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-12T18:14:41+0700",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.18 (Oracle Corporation)"
)
@ApplicationScoped
public class GameMapperImpl implements GameMapper {

    @Override
    public Game toDTO(GameEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Game.GameBuilder game = Game.builder();

        game.id( entity.getId() );
        game.name( entity.getName() );
        game.thumbnail( entity.getThumbnail() );
        game.description( entity.getDescription() );
        game.trailer( entity.getTrailer() );
        game.releasedDate( entity.getReleasedDate() );
        game.systemReq( entity.getSystemReq() );
        game.price( entity.getPrice() );

        return game.build();
    }

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
}
