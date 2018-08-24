package com.itchain.samplemsa.samplemsa.trade.port.adapter.service;

import com.itchain.samplemsa.samplemsa.trade.domain.dto.ProductInfoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpProductAdapter implements ProductAdapter {

    private static final String HOST = "localhost";
    private static final String PORT = "8080";
    private static final String PROTOCOL = "http";
    private static final String TEMPLATE = "/product/";

    public int getStockByProductId(String productId) {

        RestTemplate restTemplate = new RestTemplate();
        ProductInfoDTO productInfo = restTemplate.getForObject(PROTOCOL + "://" + HOST + ":" + PORT + TEMPLATE + productId, ProductInfoDTO.class);

        return productInfo.getQuantity();

    }

}
