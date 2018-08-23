package com.itchain.samplemsa.samplemsa.product.domain.event;

import com.itchain.samplemsa.samplemsa.common.Event;

public class ProductSalesChangedEvent implements Event {


    String productId;
    int sales;

    public ProductSalesChangedEvent(String productId, int sales) {
        this.productId = productId;
        this.sales = sales;
    }
    public int getSales(){
        return this.sales;
    }

    @Override
    public String getID() {
        return null;
    }
}
