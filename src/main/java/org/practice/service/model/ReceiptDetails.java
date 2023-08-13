package org.practice.service.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReceiptDetails {
    private Integer id;

    private Integer receiptId;

    private Integer gameCodeId;

    private Double gamePrice;
}
