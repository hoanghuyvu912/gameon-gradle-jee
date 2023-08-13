package org.practice.service.model;

import lombok.*;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.config.PropertyOrderStrategy;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Developer {
    private Integer id;

    private String name;

    private String thumbnail;

    private String coverPhoto;

    private String description;

    private LocalDate establishedDate;

    private List<Game> gameList;
}

