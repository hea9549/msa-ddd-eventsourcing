package com.itchain.samplemsa.samplemsa.mock;

import com.itchain.samplemsa.samplemsa.customer.domain.CustomerService;

public class mockCustomerService implements CustomerService {
    public boolean checkDuplicatedID(String id) {
        return true;
    }

}