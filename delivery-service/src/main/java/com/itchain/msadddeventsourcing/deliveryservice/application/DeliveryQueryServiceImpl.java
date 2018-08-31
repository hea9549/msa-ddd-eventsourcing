package com.itchain.msadddeventsourcing.deliveryservice.application;

import com.itchain.msadddeventsourcing.deliveryservice.domain.Delivery;
import com.itchain.msadddeventsourcing.deliveryservice.port.adapter.persistence.DeliveryProjectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryQueryServiceImpl implements DeliveryQueryService {

    @Autowired
    private DeliveryProjectionRepository deliveryProjectionRepository;

    @Override
    public List<Delivery> getDeliveryList() {
        return null;
    }

    @Override
    public Delivery getDeliveryInfo(String deliveryId) {
        return null;
    }
}
