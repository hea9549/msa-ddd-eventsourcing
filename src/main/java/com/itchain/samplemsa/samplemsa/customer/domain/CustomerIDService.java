package com.itchain.samplemsa.samplemsa.customer.domain;

import org.springframework.stereotype.Component;

@Component
public interface CustomerIDService {
    boolean checkDuplicatedID(String id);
}
