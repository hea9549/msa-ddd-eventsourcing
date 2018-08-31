package com.itchain.msadddeventsourcing.orderservice.port.adapter.persistence;


import com.itchain.msadddeventsourcing.orderservice.common.AggregateRepository;
import com.itchain.msadddeventsourcing.orderservice.common.EventRepository;
import com.itchain.msadddeventsourcing.orderservice.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderRepository extends AggregateRepository<Order> {

    @Autowired
    public OrderRepository(EventRepository eventRepository) {
        super(eventRepository);
    }
}
