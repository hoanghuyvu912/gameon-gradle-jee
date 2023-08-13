package org.practice.service.model;

import lombok.*;
import org.practice.entity.UserEntity;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    private Integer id;
    private Integer userId;
    private Integer gameId;
    private Integer rating;
}
