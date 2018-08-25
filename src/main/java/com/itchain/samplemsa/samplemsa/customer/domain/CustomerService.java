package com.itchain.samplemsa.samplemsa.customer.domain;

import org.springframework.stereotype.Component;

@Component
public interface CustomerService {
    boolean checkDuplicatedID(String id);
}
