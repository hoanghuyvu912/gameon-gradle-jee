package org.practice.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "developer")
public class DeveloperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "developer_name", length = 500, unique = true, nullable = false)
    @NotBlank(message = "Developer name cannot be null or blank.")
    private String name;

    @Column(name = "thumbnail", length = 1000)
    private String thumbnail;

    @Column(name = "cover_photo", length = 1000)
    private String coverPhoto;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "established_date")
    @NotNull(message = "Established date cannot be null or blank.")
    private LocalDate establishedDate;

    @OneToMany(mappedBy = "developer", cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("id, name, releasedDate")
    private List<GameEntity> gameEntityList;
}
