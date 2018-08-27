package com.itchain.samplemsa.samplemsa.customer;

import com.itchain.samplemsa.samplemsa.common.AggregateRepository;
import com.itchain.samplemsa.samplemsa.common.Event;
import com.itchain.samplemsa.samplemsa.common.EventRepository;
import com.itchain.samplemsa.samplemsa.customer.domain.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

@Component
public class CustomerRepository extends AggregateRepository<CustomerInfo> {
    public CustomerRepository(EventRepository eventRepository) {
        super(eventRepository);
    }
}
