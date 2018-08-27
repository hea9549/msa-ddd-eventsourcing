package com.itchain.samplemsa.samplemsa.delivery.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TradeInfoDTO {
    private String productId;
    private String buyerId;
    private String buyDate;
}
