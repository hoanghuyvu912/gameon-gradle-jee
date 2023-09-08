package org.practice.entity;

//import jakarta.persistence.*;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sub_genre")
public class SubGenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sub_genre_name", length = 500)
    @NotNull(message = "Sub-genre name cannot be null or blank.")
    private String name;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenreEntity genre;
}
