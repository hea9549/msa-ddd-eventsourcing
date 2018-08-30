package com.itchain.samplemsa.samplemsa.order.port.adapter.service;

import com.itchain.samplemsa.samplemsa.Config;
import com.itchain.samplemsa.samplemsa.order.domain.dto.ProductInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpProductAdapter implements ProductAdapter {

    @Autowired
    Config config;

    public int getStockByProductId(String productId) {

        RestTemplate restTemplate = new RestTemplate();
        ProductInfoDTO productInfo = restTemplate.getForObject(config.getPROTOCOL() + "://" + config.getHOST() + ":" + config.getPORT() + "/" + config.getSERVICE().get(0) + "/" + productId, ProductInfoDTO.class);

        return productInfo.getQuantity();

    }

}
