package com.itchain.samplemsa.samplemsa.product.application;

import com.itchain.samplemsa.samplemsa.product.domain.dto.ProductDTO;

import java.util.List;

public interface ProductApplicationService {

    void addProduct(String productId, String productName, String description, int price, int stock);
    void deleteProduct(String productId);
    void soldProduct(String productId, int num);
    void updateProduct(String productId, String productName, String description, int price);
    void addProductStock(String productId, int additionalStockNum);
    List<ProductDTO> getBestProduct(int num, int index);
    List<ProductDTO> getProductSortByProductName(int num, int index);
}
