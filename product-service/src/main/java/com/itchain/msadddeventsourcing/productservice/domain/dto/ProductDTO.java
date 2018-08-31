package com.itchain.msadddeventsourcing.productservice.domain.dto;

import com.itchain.msadddeventsourcing.productservice.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductDTO {

    private String productName;
    private String description;
    private int price;
    private int sales;
}
