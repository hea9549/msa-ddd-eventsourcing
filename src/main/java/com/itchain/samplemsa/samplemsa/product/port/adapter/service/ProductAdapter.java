package com.itchain.samplemsa.samplemsa.product.port.adapter.service;

import com.itchain.samplemsa.samplemsa.product.domain.dto.ProductDTO;

import java.util.List;

public interface ProductAdapter {
    public List<ProductDTO> getProductsByCategory();
}
