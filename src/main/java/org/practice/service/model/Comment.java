package org.practice.service.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    private Integer id;
    private Integer userId;
    private Integer gameId;
    private String commentContent;
    private LocalDate commentDate;
}
