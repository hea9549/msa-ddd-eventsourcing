package com.itchain.msadddeventsourcing.orderservice.port.adapter.service;


import com.itchain.msadddeventsourcing.orderservice.domain.dto.ProductInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpProductAdapter implements ProductAdapter {

    @Autowired
    @Qualifier("productRestTemplate")
    RestTemplate productRestTemplate;

    public int getStockByProductId(String productId) {
        ProductInfoDTO productInfo = productRestTemplate.getForObject("/products/"+productId,ProductInfoDTO.class);
        if (productInfo.getProductId() == null ) {
            throw new IllegalArgumentException("productInfo invalid");
        }

        return productInfo.getStock();
    }
}