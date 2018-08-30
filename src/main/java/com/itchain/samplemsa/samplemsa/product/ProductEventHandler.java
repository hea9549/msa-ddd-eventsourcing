package com.itchain.samplemsa.samplemsa.product;

import com.itchain.samplemsa.samplemsa.product.domain.Product;
import com.itchain.samplemsa.samplemsa.product.domain.event.*;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener
public class ProductEventHandler {

    @Autowired
    ProductProjectionRepository productProjectionRepository;

    @RabbitHandler
    public void handleProductCreatedEvent(ProductCreatedEvent event){
        Product product = new Product(event.getID(), event.getProductName(), event.getDescription(), event.getPrice(), event.getStock(), event.getSales());
        productProjectionRepository.addProduct(product);
    }
    @RabbitHandler
    public void handleProductDeleteEvent(ProductDeletedEvent event){
        productProjectionRepository.deleteProduct(event.getID());
    }

    @RabbitHandler
    public void handleProductUpdateEvent(ProductUpdateEvent event){
        productProjectionRepository.updateProduct(event.getID(), event.getProductName(), event.getDescription(), event.getPrice());
    }

    @RabbitHandler
    public void handleProductStockChangedEvent(ProductStockChangedEvent event){
        productProjectionRepository.changeProductStock(event.getID(), event.getStock());
    }

    @RabbitHandler
    public void handleProductSalesChangedProduct(ProductSalesChangedEvent event){
        productProjectionRepository.changeProductSales(event.getID(), event.getSales());
    }
}
