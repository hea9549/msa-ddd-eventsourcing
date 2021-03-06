package com.itchain.msadddeventsourcing.productservice.domain.event;

import com.itchain.msadddeventsourcing.productservice.common.Event;
import lombok.Getter;

@Getter
public class ProductStockChangedEvent implements Event {

    String id;
    int stock;
    public ProductStockChangedEvent(String productId, int stock){
        this.id = productId;
        this.stock = stock;
    }
    @Override
    public String getID() {
        return id;
    }

}
