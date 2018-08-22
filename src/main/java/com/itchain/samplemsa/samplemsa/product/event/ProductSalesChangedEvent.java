package com.itchain.samplemsa.samplemsa.product.event;

import com.itchain.samplemsa.samplemsa.common.Event;

public class ProductSalesChangedEvent extends Event {


    String productId;
    int sales;

    public ProductSalesChangedEvent(String productId, int sales) {
        this.productId = productId;
        this.sales = sales;
    }

    @Override
    public String getID() {
        return null;
    }
}
