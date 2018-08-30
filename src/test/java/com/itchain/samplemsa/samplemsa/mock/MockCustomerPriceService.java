package com.itchain.samplemsa.samplemsa.mock;

import com.itchain.samplemsa.samplemsa.customer.domain.CustomerPriceService;

public class MockCustomerPriceService implements CustomerPriceService {
    @Override
    public int getPriceOfSignedTrades(String customerID) {
        return 0;
    }
}
