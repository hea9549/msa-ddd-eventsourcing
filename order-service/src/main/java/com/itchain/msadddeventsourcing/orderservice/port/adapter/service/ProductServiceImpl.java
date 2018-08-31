package com.itchain.msadddeventsourcing.orderservice.port.adapter.service;

import com.itchain.msadddeventsourcing.orderservice.domain.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductAdapter productAdapter;

    public int getStockByProductId(String productId) {
        return productAdapter.getStockByProductId(productId);
    }
}
