package org.practice.service.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameSubGenre {
    private Integer id;

    private Integer gameId;

    private Integer subGenreId;
}
