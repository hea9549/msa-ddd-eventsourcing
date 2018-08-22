package com.itchain.samplemsa.samplemsa.product.event;

import com.itchain.samplemsa.samplemsa.common.Event;
import lombok.Getter;

@Getter
public class ProductUpdateEvent extends Event {
    private String id;
    private String productName;
    private String description;
    private int price;
    private int stock;

    public ProductUpdateEvent(String id, String productName, String description, int price, int stock) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String getID() {
        return null;
    }
}
