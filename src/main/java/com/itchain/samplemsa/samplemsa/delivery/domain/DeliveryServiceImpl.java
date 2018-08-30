package com.itchain.samplemsa.samplemsa.delivery.domain;

import com.itchain.samplemsa.samplemsa.common.Util;
import com.itchain.samplemsa.samplemsa.delivery.DeliveryRepository;
import com.itchain.samplemsa.samplemsa.delivery.domain.dto.DeliveryDTO;
import com.itchain.samplemsa.samplemsa.delivery.domain.dto.TradeInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;
    @Override
    public Delivery newDeliveryFromTrade(TradeInfoDTO tradeInfoDTO) {
        Delivery delivery = new Delivery(tradeInfoDTO.getProductId(),tradeInfoDTO.getBuyerId(),tradeInfoDTO.getBuyDate(), Util.getNowDateString());
        deliveryRepository.save(delivery);
        return delivery;
    }

    @Override
    public DeliveryDTO changeToDTO(Delivery delivery) {
        return new DeliveryDTO(delivery.getID(),delivery.getProductId(),delivery.getBuyerId(),delivery.getBuyDate(),delivery.getStartDate(),delivery.getDeliverStatus());
    }

    @Override
    public Delivery getDeliveryByID(String id) {
        return deliveryRepository.findById(id);
    }
}
