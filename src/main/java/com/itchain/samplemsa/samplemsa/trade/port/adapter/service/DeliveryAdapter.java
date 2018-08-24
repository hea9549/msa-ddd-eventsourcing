package com.itchain.samplemsa.samplemsa.trade.port.adapter.service;

import com.itchain.samplemsa.samplemsa.trade.domain.DeliverStatus;

public interface DeliveryAdapter {
    public DeliverStatus getDeliveryStatusByTradeId(String id);
}
