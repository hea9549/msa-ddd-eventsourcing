package com.itchain.samplemsa.samplemsa.mock;

import com.itchain.samplemsa.samplemsa.customer.domain.CustomerIDService;

public class MockCustomerIDService implements CustomerIDService {
    public boolean checkDuplicatedID(String id) {
        return true;
    }

}