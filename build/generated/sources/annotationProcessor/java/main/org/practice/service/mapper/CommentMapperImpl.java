package org.practice.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import org.practice.entity.CommentEntity;
import org.practice.entity.GameEntity;
import org.practice.entity.UserEntity;
import org.practice.service.model.Comment;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-14T00:48:17+0700",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.18 (Oracle Corporation)"
)
@ApplicationScoped
public class CommentMapperImpl implements CommentMapper {

    @Override
    public List<Comment> toDTOList(List<CommentEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<Comment> list = new ArrayList<Comment>( entityList.size() );
        for ( CommentEntity commentEntity : entityList ) {
            list.add( toDTO( commentEntity ) );
        }

        return list;
    }

    @Override
    public Comment toDTO(CommentEntity commentEntity) {
        if ( commentEntity == null ) {
            return null;
        }

        Comment.CommentBuilder comment = Comment.builder();

        comment.userId( commentEntityUserId( commentEntity ) );
        comment.gameId( commentEntityGameId( commentEntity ) );
        comment.id( commentEntity.getId() );
        comment.commentContent( commentEntity.getCommentContent() );
        comment.commentDate( commentEntity.getCommentDate() );

        return comment.build();
    }

    private Integer commentEntityUserId(CommentEntity commentEntity) {
        if ( commentEntity == null ) {
            return null;
        }
        UserEntity user = commentEntity.getUser();
        if ( user == null ) {
            return null;
        }
        Integer id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer commentEntityGameId(CommentEntity commentEntity) {
        if ( commentEntity == null ) {
            return null;
        }
        GameEntity game = commentEntity.getGame();
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
