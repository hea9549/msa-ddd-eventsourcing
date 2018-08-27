package com.itchain.samplemsa.samplemsa.delivery.domain;


import com.itchain.samplemsa.samplemsa.delivery.domain.dto.TradeInfoDTO;

public interface DeliveryService {
    Delivery deliveryFromTrade(TradeInfoDTO tradeInfoDTO);
}
