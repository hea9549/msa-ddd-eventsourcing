package com.itchain.msadddeventsourcing.orderservice.port.adapter.service;

import com.itchain.msadddeventsourcing.orderservice.domain.DeliverStatus;
import com.itchain.msadddeventsourcing.orderservice.domain.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServieImpl implements DeliveryService {

    @Autowired
    HttpDeliveryAdapter httpDeliveryAdapter;

    public boolean IsAvailableToCancel(String id) {
        DeliverStatus deliverStatus = httpDeliveryAdapter.getDeliveryStatusByTradeId(id);

        if (deliverStatus == DeliverStatus.PREPARE) {
            return true;
        } else {
            return false;
        }
    }
}
