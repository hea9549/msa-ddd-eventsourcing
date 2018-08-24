package com.itchain.samplemsa.samplemsa.trade.port.adapter.service;

import com.itchain.samplemsa.samplemsa.trade.domain.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    HttpProductAdapter httpProductAdapter;

    public int getStockByProductId(String productId) {
        return httpProductAdapter.getStockByProductId(productId);
    }
}
