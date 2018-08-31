package com.itchain.msadddeventsourcing.orderservice.port.adapter.messaging;

import com.itchain.msadddeventsourcing.orderservice.domain.Order;
import com.itchain.msadddeventsourcing.orderservice.domain.event.OrderCreatedEvent;
import com.itchain.msadddeventsourcing.orderservice.domain.event.OrderDeletedEvent;
import com.itchain.msadddeventsourcing.orderservice.port.adapter.persistence.OrderProjectionRepository;
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
