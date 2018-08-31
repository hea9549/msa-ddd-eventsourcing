package com.itchain.msadddeventsourcing.deliveryservice.application;

import com.itchain.msadddeventsourcing.deliveryservice.domain.DeliverStatus;
import com.itchain.msadddeventsourcing.deliveryservice.domain.Delivery;
import com.itchain.msadddeventsourcing.deliveryservice.domain.dto.TradeInfoDTO;
import org.springframework.stereotype.Component;

@Component
public interface DeliveryApplicationService {
   void changeDeliveryStatus(String deliveryId, DeliverStatus status);
   Delivery createDelivery(String productId, String buyerId, String buyDate);
}
