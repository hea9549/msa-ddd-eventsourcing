package com.itchain.samplemsa.samplemsa.product.domain.event;

import com.itchain.samplemsa.samplemsa.common.Event;
import lombok.Getter;

@Getter
public class ProductCreatedEvent implements Event {

    private String id;
    private String productName;
    private String description;
    private int price;
    private int stock;
    private int sales;

    public ProductCreatedEvent(String id, String productName, String description, int price, int stock, int sales) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.sales = sales;
    }

    @Override
    public String getID() {
        return id;
    }
}
