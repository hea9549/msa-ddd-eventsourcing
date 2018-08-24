package com.itchain.samplemsa.samplemsa.product.domain.event;

import com.itchain.samplemsa.samplemsa.common.Event;

public class ProductDeletedEvent implements Event {

    String productId;
    public ProductDeletedEvent(String productId){
        this.productId = productId;
    }
    @Override
    public String getID() {
        return productId;
    }

}
