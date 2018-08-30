package com.itchain.samplemsa.samplemsa.product.domain.event;

import com.itchain.samplemsa.samplemsa.common.Event;

public class ProductDeletedEvent implements Event {

    String id;
    public ProductDeletedEvent(String productId){
        this.id = productId;
    }
    @Override
    public String getID() {
        return id;
    }

}
