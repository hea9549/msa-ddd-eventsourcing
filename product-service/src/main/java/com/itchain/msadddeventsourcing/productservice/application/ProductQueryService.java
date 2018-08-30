package com.itchain.msadddeventsourcing.productservice.application;

import com.itchain.msadddeventsourcing.productservice.domain.Product;
import com.itchain.msadddeventsourcing.productservice.domain.dto.ProductDTO;

import java.util.List;

public interface ProductQueryService {
    List<Product> getBestProducts(int num, int index);
    List<Product> getProductsSortByProductName(int num, int index);
    List<Product> getProductList();
}
