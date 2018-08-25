package com.itchain.samplemsa.samplemsa.customer.port.adapter.service;

import com.itchain.samplemsa.samplemsa.customer.domain.dto.TradeInfoDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

@Component
public class HttpTradeAdapter implements TradeAdapter {
    private static final String HOST = "localhost";
    private static final String PORT = "8080";
    private static final String PROTOCOL = "http";
    private static final String TEMPLATE = "/trade/";

    @Override
    public List<TradeInfoDTO> getTradeListByCustomerID(String id) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = PROTOCOL + "://" + HOST + ":" + PORT + TEMPLATE + id;

        @NotNull
        List<TradeInfoDTO> tradeInfoDTOList = Arrays.asList(restTemplate.getForObject(uri, TradeInfoDTO[].class));
        return tradeInfoDTOList;
    }
}
