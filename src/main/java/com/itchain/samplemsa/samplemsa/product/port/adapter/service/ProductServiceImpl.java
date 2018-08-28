package com.itchain.samplemsa.samplemsa.product.port.adapter.service;

import com.itchain.samplemsa.samplemsa.product.domain.ProductService;
import com.itchain.samplemsa.samplemsa.product.domain.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class ProductServiceImpl implements ProductService {

    @Override
    public List<ProductDTO> getAllProducts() {
        return null;
    }
}
