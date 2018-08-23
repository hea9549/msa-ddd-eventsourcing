package com.itchain.samplemsa.samplemsa.customer.service;

import com.itchain.samplemsa.samplemsa.customer.domain.CustomerInfo;

public interface CustomerService {
    CustomerInfo getCustomerInfo(String id);

    void createCustomerInfo(String id, String pw, String name, String address);

    void removeCustomerInfo(String id, String pw);

    void updateCustomerInfo(String id, String pw, String name, String address);

    int calculatePoints(String id);
}
