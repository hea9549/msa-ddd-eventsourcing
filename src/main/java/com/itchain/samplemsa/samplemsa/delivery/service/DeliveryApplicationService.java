package com.itchain.samplemsa.samplemsa.delivery.service;

import com.itchain.samplemsa.samplemsa.delivery.domain.Delivery;
import com.itchain.samplemsa.samplemsa.delivery.domain.DeliverStatus;
import com.itchain.samplemsa.samplemsa.delivery.domain.dto.TradeInfoDTO;

public interface DeliveryApplicationService {
    Delivery newDeliveryServiceWithTradeInfo(TradeInfoDTO tradeInfoDTO);
    Delivery changeDeliveryStatus(String id, DeliverStatus status);
}
