package com.itchain.msadddeventsourcing.productservice.application;

public interface ProductApplicationService {
    void addProduct(String productId, String productName, String description, int price, int stock);
    void deleteProduct(String productId);
    void soldProduct(String productId, int num);
    void updateProduct(String productId, String productName, String description, int price);
    void addProductStock(String productId, int additionalStockNum);
}