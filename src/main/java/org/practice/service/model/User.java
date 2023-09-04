package org.practice.service.model;

import lombok.*;
import org.practice.entity.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    private String tel;

    private String address;

    private LocalDate dob;

    private Gender gender;

    private String profileImg;

    private Double balance;

    private LocalDate registeredDate;

    private boolean active;

    private List<UserRoleAssignment> roles = new ArrayList<>();

//    private List<ReceiptEntity> receiptEntityList = new ArrayList<>();
//
//    private List<CommentEntity> commentEntityList = new ArrayList<>();
//
//    private List<RatingEntity> ratingEntityList = new ArrayList<>();
}
