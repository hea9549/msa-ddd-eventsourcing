package com.itchain.msadddeventsourcing.deliveryservice.domain.dto;

import com.itchain.msadddeventsourcing.deliveryservice.domain.DeliverStatus;
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
