package com.itchain.samplemsa.samplemsa.product.domain;

import com.itchain.samplemsa.samplemsa.common.Aggregate;
import com.itchain.samplemsa.samplemsa.common.Event;
import com.itchain.samplemsa.samplemsa.common.OnEvent;
import com.itchain.samplemsa.samplemsa.product.event.*;
import lombok.Getter;

import java.util.List;

@Getter
public class Product extends Aggregate {

    private String id;
    private String productName;
    private String description;
    private int price;
    private int stock;
    private int sales;

    @Override
    public String getID() {
        return this.id;
    }


    public Product(String id, String productName, String description, int price, int stock, int sales) {
        ProductCreatedEvent event = new ProductCreatedEvent(id, productName, description, price, stock, sales);
        this.apply(event);
    }

    public Product(List<Event> eventList) {
        super(eventList);
    }

    @OnEvent
    private void handleCreatedEvent(ProductCreatedEvent event) {

        this.id = event.getID();
        this.productName = event.getProductName();
        this.description = event.getDescription();
        this.price = event.getPrice();
        this.stock = event.getStock();
        this.sales = event.getSales();
    }

    @OnEvent
    private void handleSoldEvent(ProductStockChangedEvent event) {
        this.stock = event.getStock();
    }

    public void sold(int num) {
        if (stock > num) {
            return;
        }
        ProductStockChangedEvent stockChangedEvent = new ProductStockChangedEvent(id, stock - num);
        ProductSalesChangedEvent salesChangedEvent = new ProductSalesChangedEvent(id, sales + num);
        this.apply(stockChangedEvent);
        this.apply(salesChangedEvent);
    }

    @OnEvent
    private void handleDeleteEvent() {
        this.id = null;
        this.productName = null;
        this.description = null;
        this.price = 0;
        this.stock = 0;
        this.sales = 0;
    }

    public void delete() {
        ProductDeletedEvent deletedEvent = new ProductDeletedEvent(id);
        this.apply(deletedEvent);
    }

    public void update(String id, String productName, String description, int price, int sales) {
        ProductUpdateEvent productUpdateEvent = new ProductUpdateEvent(id, productName, description, price, sales);
    }


}
