package com.itchain.samplemsa.samplemsa.delivery;

import com.itchain.samplemsa.samplemsa.common.AggregateRepository;
import com.itchain.samplemsa.samplemsa.delivery.domain.Delivery;
import org.springframework.stereotype.Component;

@Component
public class DeliveryRepository extends AggregateRepository<Delivery> {
}
