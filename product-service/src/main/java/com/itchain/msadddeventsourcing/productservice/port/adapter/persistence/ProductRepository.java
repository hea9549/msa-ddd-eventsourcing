package com.itchain.msadddeventsourcing.productservice.port.adapter.persistence;

import com.itchain.msadddeventsourcing.productservice.common.AggregateRepository;
import com.itchain.msadddeventsourcing.productservice.common.EventRepository;
import com.itchain.msadddeventsourcing.productservice.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository extends AggregateRepository<Product> {
    public ProductRepository(EventRepository eventRepository) {
        super(eventRepository);
    }
}
