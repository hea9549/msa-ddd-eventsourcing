package com.itchain.samplemsa.samplemsa.product.domain.event;


import com.itchain.samplemsa.samplemsa.common.Event;
import lombok.Getter;

@Getter
public class ProductStockChangedEvent implements Event {

    String id;
    int stock;
    public ProductStockChangedEvent(String aggregateId, int stock){
        this.id = aggregateId;
        this.stock = stock;
    }
    @Override
    public String getID() {
        return id;
    }

}
