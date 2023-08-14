package org.practice.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import org.practice.entity.GameEntity;
import org.practice.entity.RatingEntity;
import org.practice.entity.UserEntity;
import org.practice.service.model.Rating;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-14T07:39:27+0700",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.18 (Oracle Corporation)"
)
@ApplicationScoped
public class RatingMapperImpl implements RatingMapper {

    @Override
    public List<Rating> toDTOList(List<RatingEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<Rating> list = new ArrayList<Rating>( entityList.size() );
        for ( RatingEntity ratingEntity : entityList ) {
            list.add( toDTO( ratingEntity ) );
        }

        return list;
    }

    @Override
    public Rating toDTO(RatingEntity ratingEntity) {
        if ( ratingEntity == null ) {
            return null;
        }

        Rating.RatingBuilder rating = Rating.builder();

        rating.userId( ratingEntityUserId( ratingEntity ) );
        rating.gameId( ratingEntityGameId( ratingEntity ) );
        rating.id( ratingEntity.getId() );
        rating.rating( ratingEntity.getRating() );

        return rating.build();
    }

    private Integer ratingEntityUserId(RatingEntity ratingEntity) {
        if ( ratingEntity == null ) {
            return null;
        }
        UserEntity user = ratingEntity.getUser();
        if ( user == null ) {
            return null;
        }
        Integer id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer ratingEntityGameId(RatingEntity ratingEntity) {
        if ( ratingEntity == null ) {
            return null;
        }
        GameEntity game = ratingEntity.getGame();
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
