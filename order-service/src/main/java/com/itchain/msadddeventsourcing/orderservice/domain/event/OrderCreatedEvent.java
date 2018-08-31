package com.itchain.msadddeventsourcing.orderservice.domain.event;

import com.itchain.msadddeventsourcing.orderservice.common.Event;
import lombok.Getter;

@Getter
public class OrderCreatedEvent implements Event {
    private String id;
    private String productId;
    private String buyerId;
    private String date;
    private int price;
    private int quantity;

    public OrderCreatedEvent(String id, String productId, String buyerId, String date, int price, int quantity) {
        this.id = id;
        this.productId = productId;
        this.buyerId = buyerId;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String getID() {
        return id;
    }


}
