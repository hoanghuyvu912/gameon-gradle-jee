package org.practice.entity;

//import jakarta.persistence.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "receipt")
public class ReceiptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @CreationTimestamp
    @Column(name = "receipt_date")
    private LocalDate receiptDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "receipt", cascade = CascadeType.PERSIST)
    private List<ReceiptDetailsEntity> receiptDetailsEntityList = new ArrayList<>();
}
