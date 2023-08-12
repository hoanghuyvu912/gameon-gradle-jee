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
@Table(name = "game")
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "game_name", length = 2000)
    private String name;

    @Column(name = "thumbnail", length = 2000)
    private String thumbnail;

    @Column(name = "description", length = 3000)
    private String description;

    @Column(name = "trailer", length = 3000)
    private String trailer;

    @Column(name = "released_date")
    private LocalDate releasedDate;

    @Column(name = "system_req", length = 5000)
    private String systemReq;

    @Column(name = "price", columnDefinition = "Decimal(4,2)")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private DeveloperEntity developer;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublisherEntity publisher;

//    @OneToMany(orphanRemoval = true, mappedBy = "game", cascade = CascadeType.PERSIST)
//    private List<CommentEntity> commentEntityList = new ArrayList<>();
//
//    @OneToMany(orphanRemoval = true, mappedBy = "game", cascade = CascadeType.PERSIST)
//    private List<RatingEntity> ratingEntityList = new ArrayList<>();
//
//    @OneToMany(orphanRemoval = true, mappedBy = "game", cascade = CascadeType.PERSIST)
//    private List<GameImageEntity> gameImageEntityList = new ArrayList<>();
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

