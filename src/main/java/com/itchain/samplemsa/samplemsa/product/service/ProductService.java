package com.itchain.samplemsa.samplemsa.product.service;

import com.itchain.samplemsa.samplemsa.product.domain.Product;
import com.itchain.samplemsa.samplemsa.product.domain.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getProductsByCategory(String category);
    void addProduct(Product product);
    void deleteProduct(String productId);
    void soldProduct(String productId);
    List<ProductDTO> getBestProduct(int num);
}
