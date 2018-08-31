package com.itchain.msadddeventsourcing.customerservice.port.adapter.persistence;

import com.itchain.msadddeventsourcing.customerservice.common.AggregateRepository;
import com.itchain.msadddeventsourcing.customerservice.common.EventRepository;
import com.itchain.msadddeventsourcing.customerservice.domain.CustomerInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository extends AggregateRepository<CustomerInfo> {

    public CustomerRepository(EventRepository eventRepository) {
        super(eventRepository);
    }
}
