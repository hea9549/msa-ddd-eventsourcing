package com.itchain.samplemsa.samplemsa.product.domain.event;

import com.itchain.samplemsa.samplemsa.common.Event;

public class ProductSalesChangedEvent implements Event {


    String id;
    int sales;

    public ProductSalesChangedEvent(String productId, int sales) {
        this.id = productId;
        this.sales = sales;
    }
    public int getSales(){
        return this.sales;
    }

    @Override
    public String getID() {
        return id;
    }
}
