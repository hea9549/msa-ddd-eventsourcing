package com.itchain.samplemsa.samplemsa.product.application;

import com.itchain.samplemsa.samplemsa.product.domain.Product;
import com.itchain.samplemsa.samplemsa.product.domain.dto.ProductDTO;

import java.util.List;

public interface ProductApplicationService {

    List<ProductDTO> getProductsByCategory(String category);
    void addProduct(String productId, String productName, String description, int price, int stock);
    void deleteProduct(String productId);
    void soldProduct(String productId, int num);
    List<ProductDTO> getBestProduct(int num);
    List<ProductDTO> getProducts();
}
