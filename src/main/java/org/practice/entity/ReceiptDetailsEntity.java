package org.practice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "receipt_details")
public class ReceiptDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "receipt_id")
    private ReceiptEntity receipt;

    @OneToOne
    @JoinColumn(name = "game_code_id")
    private GameCodeEntity gameCodeEntity;

    @Column(name="game_price", columnDefinition="Decimal(4,2)")
    private Double gamePrice;

}
