package com.itchain.msadddeventsourcing.deliveryservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradeInfoDTO {
    private String productId;
    private String buyerId;
    private String buyDate;
}
