package org.practice.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "game_code")
public class GameCodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "game_code", unique = true, updatable = false)
    @NotBlank(message = "Comment date cannot be null or blank.")
    private String gameCode;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameEntity game;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private GameCodeStatus gameCodeStatus;
}
