package com.itchain.msadddeventsourcing.orderservice.port.adapter.service;

import com.itchain.msadddeventsourcing.orderservice.domain.DeliverStatus;

public interface DeliveryAdapter {
    public DeliverStatus getDeliveryStatusByTradeId(String id);
}
