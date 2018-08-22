package com.itchain.samplemsa.samplemsa.product;

import com.itchain.samplemsa.samplemsa.common.AggregateRepository;
import com.itchain.samplemsa.samplemsa.product.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository extends AggregateRepository<Product> {
}
