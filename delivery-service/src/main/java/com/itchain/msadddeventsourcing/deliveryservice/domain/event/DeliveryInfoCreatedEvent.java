package com.itchain.msadddeventsourcing.deliveryservice.domain.event;

import com.itchain.msadddeventsourcing.deliveryservice.common.Event;
import lombok.Getter;

@Getter
public class DeliveryInfoCreatedEvent implements Event {

    private String id;
    private String productId;
    private String buyerId;
    private String buyDate;
    private String startDate;
    public DeliveryInfoCreatedEvent(String id, String productId, String buyerId, String buyDate,String startDate){
        this.id = id;
        this.productId = productId;
        this.buyerId= buyerId;
        this.buyDate = buyDate;
        this.startDate= startDate;
    }
    @Override
    public String getID() {
        return id;
    }

}
