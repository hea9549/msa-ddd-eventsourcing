package com.itchain.samplemsa.samplemsa.delivery.application;

import com.itchain.samplemsa.samplemsa.delivery.domain.DeliverStatus;
import com.itchain.samplemsa.samplemsa.delivery.domain.Delivery;

import org.springframework.stereotype.Component;

@Component
public interface DeliveryApplicationService {
   Delivery changeDeliveryStatus(String deliveryId, DeliverStatus status);
}
