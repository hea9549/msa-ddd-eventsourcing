package com.itchain.samplemsa.samplemsa.trade.domain.dto;

import com.itchain.samplemsa.samplemsa.trade.domain.DeliverStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DeliveryInfoDTO {
    private String id;
    private String productId;
    private DeliverStatus Status;

}
