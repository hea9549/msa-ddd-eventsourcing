package com.itchain.msadddeventsourcing.productservice.domain.event;

import com.itchain.msadddeventsourcing.productservice.common.Event;
import lombok.Getter;

@Getter
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
