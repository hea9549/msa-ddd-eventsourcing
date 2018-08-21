package com.itchain.samplemsa.samplemsa.delivery.domain.dto;

import com.itchain.samplemsa.samplemsa.delivery.domain.DeliverStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DeliveryDTO {
    private String id;
    private String productId;
    private String buyerId;
    private String buyDate;
    private String startDate;
    private DeliverStatus deliverStatus;
}
