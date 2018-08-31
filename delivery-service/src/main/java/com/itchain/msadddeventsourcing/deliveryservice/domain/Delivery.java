package com.itchain.msadddeventsourcing.deliveryservice.domain;


import com.itchain.msadddeventsourcing.deliveryservice.common.Aggregate;
import com.itchain.msadddeventsourcing.deliveryservice.common.Event;
import com.itchain.msadddeventsourcing.deliveryservice.common.OnEvent;
import com.itchain.msadddeventsourcing.deliveryservice.domain.event.DeliveryInfoChangedEvent;
import com.itchain.msadddeventsourcing.deliveryservice.domain.event.DeliveryInfoCreatedEvent;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Delivery extends Aggregate {


    private String id;
    private String productId;
    private String buyerId;
    private String buyDate;
    private String startDate;
    private DeliverStatus deliverStatus;

    public Delivery(String productId,String buyerId,String buyDate,String startDate){
        apply(new DeliveryInfoCreatedEvent(UUID.randomUUID().toString(),productId,buyerId,buyDate,startDate));
    }

    public Delivery(List<Event> events){
        super(events);
    }

    @Override
    public String getID() {
        return id;
    }

    @OnEvent
    public void onDeliveryCreatedEvent(DeliveryInfoCreatedEvent event){
        this.id = event.getID();
        this.buyDate = event.getBuyDate();
        this.buyerId = event.getBuyerId();
        this.productId = event.getProductId();
        this.startDate = event.getStartDate();
        this.deliverStatus = DeliverStatus.PREPARE;
    }

    @OnEvent
    public void onDeliveryChangeEvent(DeliveryInfoChangedEvent event){
        if(this.id == null || !this.id.equals(event.getID())){
            throw new IllegalArgumentException();
        }
        this.deliverStatus = event.getStatus();
    }

    public void changeStatus(DeliverStatus status){
        DeliveryInfoChangedEvent changedEvent = new DeliveryInfoChangedEvent(id,status);
        switch (status) {
            case PREPARE:
                if (this.deliverStatus != DeliverStatus.DELIVERING || this.deliverStatus != DeliverStatus.DONE){
                    this.apply(changedEvent);
                    return;
                }
            case DELIVERING:
                if (this.deliverStatus != DeliverStatus.DONE){
                    this.apply(changedEvent);
                    return;
                }
            case DONE:
                this.apply(changedEvent);
            default:
        }

        throw new RuntimeException("invalid status change");
    }
}
