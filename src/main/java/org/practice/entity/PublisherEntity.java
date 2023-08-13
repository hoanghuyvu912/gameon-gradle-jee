package org.practice.entity;

//import jakarta.persistence.*;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "publisher")
public class PublisherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "publisher_name")
    private String name;

    @Column(name = "thumbnail", length = 1000)
    private String thumbnail;

    @Column(name = "cover_photo", length = 1000)
    private String coverPhoto;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "established_date")
    private LocalDate establishedDate;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.PERSIST)
    private List<GameEntity> gameEntityList = new ArrayList<>();
}
