package com.itchain.samplemsa.samplemsa.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductDTO {

    private String productName;
    private String description;
    private int price;


    public ProductDTO(Product product){
        this.productName = product.getProductName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }
}
