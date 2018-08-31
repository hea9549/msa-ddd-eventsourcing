package com.itchain.msadddeventsourcing.customerservice.web.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderInfoDTO {
    private String id;
    private int price;
    private int quantity;
    private OrderStatus status;
}
