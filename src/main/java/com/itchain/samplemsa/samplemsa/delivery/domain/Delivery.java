package com.itchain.samplemsa.samplemsa.delivery.domain;

import com.google.gson.Gson;
import com.itchain.samplemsa.samplemsa.common.Aggregate;
import com.itchain.samplemsa.samplemsa.common.Event;
import com.itchain.samplemsa.samplemsa.common.EventRepository;
import com.itchain.samplemsa.samplemsa.common.OnEvent;
import com.itchain.samplemsa.samplemsa.delivery.domain.event.DeliveryInfoChangedEvent;
import com.itchain.samplemsa.samplemsa.delivery.domain.event.DeliveryInfoCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public boolean changeStatus(DeliverStatus status){
        DeliveryInfoChangedEvent changedEvent = new DeliveryInfoChangedEvent(id,status);
        switch (status) {
            case PREPARE:
                if (this.deliverStatus == DeliverStatus.DELIVERING || this.deliverStatus == DeliverStatus.DONE){
                    return false;
                }
                this.apply(changedEvent);
                return true;
            case DELIVERING:
                if (this.deliverStatus == DeliverStatus.DONE){
                    return false;
                }

                this.apply(changedEvent);
                return true;
            case DONE:
                this.apply(changedEvent);
                return true;
            default:
                return false;
        }
    }
}
