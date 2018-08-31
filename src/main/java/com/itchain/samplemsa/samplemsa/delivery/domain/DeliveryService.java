package com.itchain.samplemsa.samplemsa.delivery.domain;

import com.itchain.samplemsa.samplemsa.delivery.domain.dto.DeliveryDTO;
import com.itchain.samplemsa.samplemsa.delivery.domain.dto.TradeInfoDTO;
import org.springframework.stereotype.Component;

@Component
public interface DeliveryService {
    Delivery newDeliveryFromTrade(TradeInfoDTO tradeInfoDTO);
    DeliveryDTO changeToDTO(Delivery delivery);
    Delivery getDeliveryByID(String id);
}