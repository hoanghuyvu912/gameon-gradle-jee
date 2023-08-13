package org.practice.service.model;

import lombok.*;
import org.practice.entity.DeveloperEntity;
import org.practice.entity.PublisherEntity;

import javax.xml.stream.events.Comment;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Game {
    private Integer id;

    private String name;

    private String thumbnail;

    private String description;

    private String trailer;

    private LocalDate releasedDate;

    private String systemReq;

    private Double price;

    private Integer developerId;

    private Integer publisherId;

    private List<Comment> comments;
}
