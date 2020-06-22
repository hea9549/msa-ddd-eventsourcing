package com.itchain.msadddeventsourcing.productservice.application;

import com.itchain.msadddeventsourcing.productservice.domain.Product;
import com.itchain.msadddeventsourcing.productservice.domain.dto.ProductDTO;

import java.util.List;

public interface ProductQueryService {
    List<ProductDTO> getBestProducts(int num);
    List<Product> getProductList();
    Product getProductById(String productId);
}
