package com.itchain.samplemsa.samplemsa.order;

import com.itchain.samplemsa.samplemsa.common.AggregateRepository;
import com.itchain.samplemsa.samplemsa.common.EventRepository;
import com.itchain.samplemsa.samplemsa.order.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderRepository extends AggregateRepository<Order> {

    @Autowired
    public OrderRepository(EventRepository eventRepository) {
        super(eventRepository);
    }
}
