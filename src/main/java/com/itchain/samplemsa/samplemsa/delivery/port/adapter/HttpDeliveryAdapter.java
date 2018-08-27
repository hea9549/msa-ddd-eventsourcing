package com.itchain.samplemsa.samplemsa.delivery.port.adapter;

import com.itchain.samplemsa.samplemsa.delivery.domain.Delivery;
import com.itchain.samplemsa.samplemsa.delivery.domain.dto.DeliveryDTO;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class HttpDeliveryAdapter {
    private static final String HOST = "localhost";
    private static final String PORT = "8080";
    private static final String PROTOCOL = "http";
    private static final String TEMPLATE = "/deliveries/";

    //todo impl
    DeliveryDTO getDeliverInfo(String id){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(PROTOCOL + "://" + HOST + ":" + PORT + TEMPLATE + id, DeliveryDTO.class);
    }
    List<DeliveryDTO> getDeliverInfos(){
        RestTemplate restTemplate = new RestTemplate();
        return Arrays.asList(restTemplate.getForObject(PROTOCOL + "://" + HOST + ":" + PORT + TEMPLATE, DeliveryDTO[].class));
    }
}
