package com.itchain.samplemsa.samplemsa.order.domain.command;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateOrderCommand {
    private String productId;
    private String buyerId;
    private String signedDate;
    private int price;
    private int quantity;
}
