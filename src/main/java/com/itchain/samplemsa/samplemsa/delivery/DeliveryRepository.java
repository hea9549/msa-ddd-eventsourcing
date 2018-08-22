package com.itchain.samplemsa.samplemsa.delivery;

import com.itchain.samplemsa.samplemsa.common.AggregateRepository;
import com.itchain.samplemsa.samplemsa.common.EventRepository;
import com.itchain.samplemsa.samplemsa.delivery.domain.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DeliveryRepository extends AggregateRepository<Delivery> {
    @Autowired
    @Qualifier("eventRepositoryImpl")
    private EventRepository eventRepository;
}
