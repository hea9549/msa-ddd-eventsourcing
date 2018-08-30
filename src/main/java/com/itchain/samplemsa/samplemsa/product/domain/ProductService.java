package com.itchain.samplemsa.samplemsa.product.domain;

import com.itchain.samplemsa.samplemsa.product.domain.dto.ProductDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {
    List<ProductDTO> getAllProducts();
}
