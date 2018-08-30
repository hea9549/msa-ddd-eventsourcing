package com.itchain.samplemsa.samplemsa.delivery.application;

import com.itchain.samplemsa.samplemsa.delivery.DeliveryRepository;
import com.itchain.samplemsa.samplemsa.delivery.domain.DeliverStatus;
import com.itchain.samplemsa.samplemsa.delivery.domain.Delivery;
import com.itchain.samplemsa.samplemsa.delivery.domain.DeliveryService;
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
    public Delivery changeDeliveryStatus(String id, DeliverStatus status) {
        Delivery delivery = deliveryRepository.findById(id);
        if (delivery.changeStatus(status)){
            deliveryRepository.save(delivery);
        }
        return delivery;
    }
}
