package com.itchain.samplemsa.samplemsa.trade.port.adapter.service;

import com.itchain.samplemsa.samplemsa.Config;
import com.itchain.samplemsa.samplemsa.trade.domain.DeliverStatus;
import com.itchain.samplemsa.samplemsa.trade.domain.dto.DeliveryInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpDeliveryAdapter implements DeliveryAdapter {

    @Autowired
    Config config;

    public DeliverStatus getDeliveryStatusByTradeId(String id) {

        RestTemplate restTemplate = new RestTemplate();
        DeliveryInfoDTO deliveryInfoDTO = restTemplate.getForObject( config.getPROTOCOL()+ "://" + config.getHOST() + ":" + config.getPORT() + "/" + config.getSERVICE().get(1) + "/" + id, DeliveryInfoDTO.class);
        return deliveryInfoDTO.getStatus();
    }


}
