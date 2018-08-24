package com.itchain.samplemsa.samplemsa.trade.domain.command;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateTradeCommand {
    private String productId;
    private String buyerId;
    private String signedDate;
    private int price;
    private int quantity;
}
