package com.itchain.msadddeventsourcing.deliveryservice.application;

import com.itchain.msadddeventsourcing.deliveryservice.domain.Delivery;
import org.springframework.stereotype.Service;


import java.util.List;

public interface DeliveryQueryService {
    List<Delivery> getDeliveryList();
    Delivery getDeliveryInfo(String deliveryId);
}
