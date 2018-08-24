package com.itchain.samplemsa.samplemsa.trade.domain;


import com.itchain.samplemsa.samplemsa.common.Aggregate;
import com.itchain.samplemsa.samplemsa.common.Event;
import com.itchain.samplemsa.samplemsa.common.OnEvent;
import com.itchain.samplemsa.samplemsa.trade.domain.event.TradeCreatedEvent;
import com.itchain.samplemsa.samplemsa.trade.domain.event.TradeDeletedEvent;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Trade extends Aggregate {

    private String id;
    private String productId;
    private String buyerId;
    private String signedDate;
    private String cancelledDate;
    private int price;
    private int quantity;
    private TradeStatus status;

    public Trade(String productId, String buyerId, String signedDate, int price, int quantity ) {
        apply(new TradeCreatedEvent(UUID.randomUUID().toString(), productId, buyerId, signedDate, price, quantity));
    }

    public Trade(List<Event> events) { super(events);}

    @Override
    public String getID() {return id;}

    public void cancel() {
        TradeDeletedEvent event = new TradeDeletedEvent(id);
        this.apply(event);

    }

    @OnEvent
    public void onTradeCreatedEvent(TradeCreatedEvent event) {
        this.id = event.getID();
        this.productId = event.getProductId();
        this.buyerId = event.getBuyerId();
        this.signedDate = event.getDate();
        this.price = event.getPrice();
        this.quantity = event.getQuantity();
        this.status = TradeStatus.SIGNED;
    }

    @OnEvent
    public void onTradeDeletedEvent(TradeDeletedEvent event) {
        if (this.id == null || !this.id.equals(event.getID())) {
            throw new IllegalArgumentException();
        }

        this.status = TradeStatus.CANCELED;
    }




}
