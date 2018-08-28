package com.itchain.samplemsa.samplemsa.customer.domain.dto;

import com.itchain.samplemsa.samplemsa.order.domain.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TradeInfoDTO {
    private String id;
    private int price;
    private int quantity;
    private OrderStatus status;
}
