package com.itchain.samplemsa.samplemsa.customer.domain.dto;

import com.itchain.samplemsa.samplemsa.trade.domain.TradeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TradeInfoDTO {
    private String id;
    private int price;
    private int quantity;
    private TradeStatus status;
}
