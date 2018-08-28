package com.itchain.samplemsa.samplemsa.order.port.adapter.service;

import com.itchain.samplemsa.samplemsa.order.domain.DeliverStatus;

public interface DeliveryAdapter {
    public DeliverStatus getDeliveryStatusByTradeId(String id);
}
