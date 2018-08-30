package com.itchain.samplemsa.samplemsa.order;

import com.itchain.samplemsa.samplemsa.order.domain.Order;
import com.itchain.samplemsa.samplemsa.order.domain.event.OrderCreatedEvent;
import com.itchain.samplemsa.samplemsa.order.domain.event.OrderDeletedEvent;
import com.itchain.samplemsa.samplemsa.product.ProductProjectionRepository;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener
public class OrderEventHandler {
    @Autowired
    OrderProjectionRepository orderProjectionRepository;

    @RabbitHandler
    public void handlerOrderCreatedEvent(OrderCreatedEvent event) {
        Order order = new Order(event.getID(), event.getBuyerId(), event.getDate(), event.getPrice(), event.getQuantity());
        orderProjectionRepository.addOrder(order);
    }

    @RabbitHandler
    public void handleOrderDeletedEvent(OrderDeletedEvent event) {
        orderProjectionRepository.deleteOrder(event.getID());
    }


}
