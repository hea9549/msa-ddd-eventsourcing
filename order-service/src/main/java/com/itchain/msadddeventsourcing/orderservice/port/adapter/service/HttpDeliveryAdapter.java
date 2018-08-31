package com.itchain.msadddeventsourcing.orderservice.port.adapter.service;

import com.itchain.msadddeventsourcing.orderservice.domain.DeliverStatus;
import com.itchain.msadddeventsourcing.orderservice.domain.dto.DeliveryInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpDeliveryAdapter implements DeliveryAdapter {

    @Autowired
    @Qualifier("deliveryRestTemplate")
    RestTemplate deliveryRestTemplate;

    public DeliverStatus getDeliveryStatusByTradeId(String id) {
        DeliveryInfoDTO deliveryInfoDTO = deliveryRestTemplate.getForObject("/deliverys",DeliveryInfoDTO.class);
        return deliveryInfoDTO.getStatus();
    }
}
