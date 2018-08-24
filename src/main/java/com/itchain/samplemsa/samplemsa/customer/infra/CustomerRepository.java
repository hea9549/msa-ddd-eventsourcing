package com.itchain.samplemsa.samplemsa.customer.infra;

import com.itchain.samplemsa.samplemsa.common.AggregateRepository;
import com.itchain.samplemsa.samplemsa.common.EventRepository;
import com.itchain.samplemsa.samplemsa.customer.domain.CustomerInfo;
import org.springframework.stereotype.Component;

@Component
public class CustomerRepository extends AggregateRepository<CustomerInfo> {
}
