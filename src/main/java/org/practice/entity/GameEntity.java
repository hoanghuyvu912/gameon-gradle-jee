package org.practice.entity;

//import jakarta.persistence.*;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "game")
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "game_name", length = 2000)
    @NotNull(message = "Game name cannot be null or blank.")
    private String name;

    @Column(name = "thumbnail", length = 2000)
    private String thumbnail;

    @Column(name = "description", length = 3000)
    private String description;

    @Column(name = "trailer", length = 3000)
    private String trailer;

    @Column(name = "released_date")
    @NotNull(message = "Released date cannot be null or blank.")
    private LocalDate releasedDate;

    @Column(name = "system_req", length = 5000)
    private String systemReq;

    @Column(name = "price", columnDefinition = "Decimal(4,2)")
    @NotNull(message = "Price cannot be null or blank.")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private DeveloperEntity developer;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublisherEntity publisher;

    @OneToMany(orphanRemoval = true, mappedBy = "game", cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SUBSELECT)
    private List<CommentEntity> commentEntityList;

    @OneToMany(orphanRemoval = true, mappedBy = "game", cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SUBSELECT)
    private List<RatingEntity> ratingEntityList = new ArrayList<>();

    @OneToMany(orphanRemoval = true, mappedBy = "game", cascade = CascadeType.PERSIST)
    private List<GameImageEntity> gameImageEntityList = new ArrayList<>();
//
//    @OneToMany(orphanRemoval = true, mappedBy = "game", cascade = CascadeType.PERSIST)
//    private List<GameSubGenreEntity> gameSubGenreEntityList = new ArrayList<>();
//
//    @OneToMany(orphanRemoval = true, mappedBy = "game", cascade = CascadeType.PERSIST)
//    private List<GameGenreEntity> gameGenreEntityList = new ArrayList<>();
//
//    @OneToMany(mappedBy = "game", cascade = CascadeType.PERSIST)
//    private List<GameCodeEntity> gameCodeEntityList = new ArrayList<>();
}

