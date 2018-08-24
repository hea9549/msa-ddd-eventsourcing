package com.itchain.samplemsa.samplemsa.trade.port.adapter.service;

import com.itchain.samplemsa.samplemsa.trade.domain.DeliverStatus;
import com.itchain.samplemsa.samplemsa.trade.domain.dto.DeliveryInfoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpDeliveryAdapter implements DeliveryAdapter {
    private static final String HOST = "localhost";
    private static final String PORT = "8080";
    private static final String PROTOCOL = "http";
    private static final String TEMPLATE = "/delivery/";

    public DeliverStatus getDeliveryStatusByTradeId(String id) {

        RestTemplate restTemplate = new RestTemplate();
        DeliveryInfoDTO deliveryInfoDTO = restTemplate.getForObject(PROTOCOL + "://" + HOST + ":" + PORT + TEMPLATE + id, DeliveryInfoDTO.class);
        return deliveryInfoDTO.getStatus();
    }


}
