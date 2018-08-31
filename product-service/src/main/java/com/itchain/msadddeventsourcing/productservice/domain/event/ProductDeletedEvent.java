package com.itchain.msadddeventsourcing.productservice.domain.event;


import com.itchain.msadddeventsourcing.productservice.common.Event;

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
