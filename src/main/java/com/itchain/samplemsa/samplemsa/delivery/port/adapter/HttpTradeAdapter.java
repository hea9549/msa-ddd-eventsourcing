package com.itchain.samplemsa.samplemsa.delivery.port.adapter;

import com.itchain.samplemsa.samplemsa.customer.domain.dto.TradeInfoDTO;
import org.springframework.web.client.RestTemplate;

public class HttpTradeAdapter {
    private static final String HOST = "localhost";
    private static final String PORT = "8080";
    private static final String PROTOCOL = "http";
    private static final String TEMPLATE = "/trades/";

    public TradeInfoDTO getTradeById(String tradeId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(PROTOCOL + "://" + HOST + ":" + PORT + TEMPLATE + tradeId, TradeInfoDTO.class);
    }
}
