package com.itchain.msadddeventsourcing.deliveryservice.application;

import com.itchain.msadddeventsourcing.deliveryservice.common.Util;
import com.itchain.msadddeventsourcing.deliveryservice.domain.dto.TradeInfoDTO;
import com.itchain.msadddeventsourcing.deliveryservice.port.adapter.persistence.DeliveryRepository;
import com.itchain.msadddeventsourcing.deliveryservice.domain.DeliverStatus;
import com.itchain.msadddeventsourcing.deliveryservice.domain.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeliveryApplicationServiceImpl implements DeliveryApplicationService {

    private DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryApplicationServiceImpl(DeliveryRepository deliveryRepository){
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public void changeDeliveryStatus(String id, DeliverStatus status) {
        Delivery delivery = deliveryRepository.findById(id);
        delivery.changeStatus(status);
        deliveryRepository.save(delivery);
    }

    @Override
    public Delivery createDelivery(String productId, String buyerId, String buyDate) {
        Delivery delivery = new Delivery(productId,buyerId,buyDate, Util.getNowDateString());
        deliveryRepository.save(delivery);

        return delivery;
    }
}
