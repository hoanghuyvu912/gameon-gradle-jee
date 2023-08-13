package org.practice.service.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Receipt {
    private Integer id;

    private Integer userId;

    private LocalDate receiptDate;

    private List<Receipt> receiptDetailsList;
}
