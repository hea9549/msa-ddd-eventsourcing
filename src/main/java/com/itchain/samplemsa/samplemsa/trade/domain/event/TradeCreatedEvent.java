package com.itchain.samplemsa.samplemsa.trade.domain.event;

import com.itchain.samplemsa.samplemsa.common.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class TradeCreatedEvent implements Event {
    private String id;
    private String productId;
    private String buyerId;
    private String date;
    private int price;
    private int quantity;

    public TradeCreatedEvent(String id, String productId, String buyerId, String date, int price, int quantity) {
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
