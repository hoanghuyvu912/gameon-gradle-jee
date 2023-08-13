package org.practice.service.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameImage {
    private Integer id;

    private String imageLink;

    private Integer gameId;
}
