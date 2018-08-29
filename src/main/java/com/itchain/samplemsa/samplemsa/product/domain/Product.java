package com.itchain.samplemsa.samplemsa.product.domain;

import com.itchain.samplemsa.samplemsa.common.Aggregate;
import com.itchain.samplemsa.samplemsa.common.Event;
import com.itchain.samplemsa.samplemsa.common.OnEvent;
import com.itchain.samplemsa.samplemsa.product.domain.event.*;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
public class Product extends Aggregate {

    @Id
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

    public void soldProduct(int num) {
        if (stock < num && id != null) {
            ProductStockChangedEvent stockChangedEvent = new ProductStockChangedEvent(id, stock - num);
            ProductSalesChangedEvent salesChangedEvent = new ProductSalesChangedEvent(id, sales + num);
            this.apply(stockChangedEvent);
            this.apply(salesChangedEvent);
        }
    }

    public void addProductStock(int num) {
        if (id != null) {
            num += this.stock;
            ProductStockChangedEvent event = new ProductStockChangedEvent(id, num);
            this.apply(event);
        }
    }

    public void deleteProduct() {
        if (id != null) {
            ProductDeletedEvent deletedEvent = new ProductDeletedEvent(id);
            this.apply(deletedEvent);
        }
    }

    public void updateProduct(String productName, String description, int price) {
        if (id != null) {
            ProductUpdateEvent productUpdateEvent = new ProductUpdateEvent(productName, description, price);
            this.apply(productUpdateEvent);
        }
    }

    @OnEvent
    private void onProductCreatedEvent(ProductCreatedEvent event) {

        this.id = event.getID();
        this.productName = event.getProductName();
        this.description = event.getDescription();
        this.price = event.getPrice();
        this.stock = event.getStock();
        this.sales = event.getSales();
    }

    @OnEvent
    private void onProductDeleteEvent(ProductDeletedEvent event) {
        this.id = null;
        this.productName = null;
        this.description = null;
        this.price = 0;
        this.stock = 0;
        this.sales = 0;
    }

    @OnEvent
    public void onProductUpdateEvent(ProductUpdateEvent event) {
        this.productName = event.getProductName();
        this.description = event.getDescription();
        this.price = event.getPrice();
    }

    @OnEvent
    private void onProductSoldEvent(ProductStockChangedEvent event) {
        this.stock = event.getStock();
    }

    @OnEvent
    private void onProductChangeSalesEvent(ProductSalesChangedEvent event) {
        this.stock = event.getSales();
    }


}
