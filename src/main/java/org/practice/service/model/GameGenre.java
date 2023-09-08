package org.practice.service.model;

import lombok.*;
import org.practice.entity.GameEntity;
import org.practice.entity.GenreEntity;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameGenre {
    private Integer id;

    private Integer gameId;

    private Integer genreId;
}
