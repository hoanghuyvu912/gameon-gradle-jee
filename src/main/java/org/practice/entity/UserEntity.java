package org.practice.entity;

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
@Table(name = "user_info")
@NamedQuery(
        name = UserEntity.GET_BY_GENDER,
        query = "SELECT u from UserEntity u where u.gender = :gender"
)
public class UserEntity {
    public static final String GET_BY_GENDER = "UserEntity.findByGender";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name", length = 500)
    private String firstName;

    @Column(name = "last_name", length = 500)
    private String lastName;

    @Column(name = "username", length = 500)
    private String username;

    @Column(name = "user_password", length = 1000)
    private String password;

    @Column(name = "email", length = 1000)
    private String email;

    @Column(name = "telephone_num")
    private String tel;

    @Column(name = "address", length = 2000)
    private String address;

    @Column(name = "dob")
    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "profile_img", length = 5000)
    private String profileImg;

    @Column(name = "balance", columnDefinition = "Decimal(20,2)")
    private Double balance;

    @Column(name = "registered_date")
    private LocalDate registeredDate;

    @Column(name = "active")
    private boolean active;

    @OneToMany(orphanRemoval = true, mappedBy = "users", cascade = CascadeType.PERSIST)
    private List<UserRoleAssignment> roles = new ArrayList<>();

//    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
//    private List<ReceiptEntity> receiptEntityList = new ArrayList<>();
//
//    @OneToMany(orphanRemoval = true, mappedBy = "user", cascade = CascadeType.PERSIST)
//    private List<CommentEntity> commentEntityList = new ArrayList<>();
//
//    @OneToMany(orphanRemoval = true, mappedBy = "user", cascade = CascadeType.PERSIST)
//    private List<RatingEntity> ratingEntityList = new ArrayList<>();
}
