package com.itchain.msadddeventsourcing.deliveryservice.port.adapter.persistence;

import com.itchain.msadddeventsourcing.deliveryservice.common.AggregateRepository;
import com.itchain.msadddeventsourcing.deliveryservice.common.EventRepository;
import com.itchain.msadddeventsourcing.deliveryservice.domain.Delivery;
import org.springframework.stereotype.Component;

@Component
public class DeliveryRepository extends AggregateRepository<Delivery> {
    public DeliveryRepository(EventRepository eventRepository) {
        super(eventRepository);
    }
}