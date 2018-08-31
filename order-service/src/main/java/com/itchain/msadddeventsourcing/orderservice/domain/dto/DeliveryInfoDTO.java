package com.itchain.msadddeventsourcing.orderservice.domain.dto;

import com.itchain.msadddeventsourcing.orderservice.domain.DeliverStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DeliveryInfoDTO {
    private String id;
    private String productId;
    private DeliverStatus Status;

}
