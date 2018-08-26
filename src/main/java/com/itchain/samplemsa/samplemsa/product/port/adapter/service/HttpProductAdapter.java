package com.itchain.samplemsa.samplemsa.product.port.adapter.service;

import com.itchain.samplemsa.samplemsa.product.domain.dto.ProductDTO;

import java.util.List;

public class HttpProductAdapter implements ProductAdapter {

    private static final String HOST = "localhost";
    private static final String PORT = "8080";
    private static final String PROTOCOL = "http";
    private static final String TEMPLATE = "/product/";

    @Override
    public List<ProductDTO> getProductsByCategory() {
        return null;
    }
}
