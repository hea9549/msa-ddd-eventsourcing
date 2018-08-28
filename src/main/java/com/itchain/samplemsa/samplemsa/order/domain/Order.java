package com.itchain.samplemsa.samplemsa.order.domain;


import com.itchain.samplemsa.samplemsa.common.Aggregate;
import com.itchain.samplemsa.samplemsa.common.Event;
import com.itchain.samplemsa.samplemsa.common.OnEvent;
import com.itchain.samplemsa.samplemsa.order.domain.event.OrderCreatedEvent;
import com.itchain.samplemsa.samplemsa.order.domain.event.OrderDeletedEvent;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Order extends Aggregate {

    private String id;
    private String productId;
    private String buyerId;
    private String signedDate;
    private String cancelledDate;
    private int price;
    private int quantity;
    private OrderStatus status;

    public Order(String productId, String buyerId, String signedDate, int price, int quantity ) {
        apply(new OrderCreatedEvent(UUID.randomUUID().toString(), productId, buyerId, signedDate, price, quantity));
    }

    public Order(List<Event> events) { super(events);}

    @Override
    public String getID() {return id;}

    public void cancel() {
        OrderDeletedEvent event = new OrderDeletedEvent(id);
        this.apply(event);

    }

    @OnEvent
    public void onTradeCreatedEvent(OrderCreatedEvent event) {
        this.id = event.getID();
        this.productId = event.getProductId();
        this.buyerId = event.getBuyerId();
        this.signedDate = event.getDate();
        this.price = event.getPrice();
        this.quantity = event.getQuantity();
        this.status = OrderStatus.SIGNED;
    }

    @OnEvent
    public void onTradeDeletedEvent(OrderDeletedEvent event) {
        if (this.id == null || !this.id.equals(event.getID())) {
            throw new IllegalArgumentException();
        }

        this.status = OrderStatus.CANCELED;
    }




}
