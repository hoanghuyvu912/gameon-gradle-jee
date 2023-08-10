package org.practice.entity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Column(name = "developer_name")
    private String name;

    @Column(name = "thumbnail", length = 1000)
    private String thumbnail;

    @Column(name = "cover_photo", length = 1000)
    private String coverPhoto;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "established_date")
    private LocalDate establishedDate;
}
