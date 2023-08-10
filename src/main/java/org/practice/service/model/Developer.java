package org.practice.service.model;

import lombok.*;

import java.time.LocalDate;

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
}

