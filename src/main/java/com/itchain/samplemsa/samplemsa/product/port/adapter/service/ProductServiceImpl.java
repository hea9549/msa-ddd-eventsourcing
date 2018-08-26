package com.itchain.samplemsa.samplemsa.product.port.adapter.service;

import com.itchain.samplemsa.samplemsa.product.domain.ProductService;
import org.springframework.beans.factory.annotation.Autowired;


public class ProductServiceImpl implements ProductService {

    @Autowired
    HttpProductAdapter adapter;


}
