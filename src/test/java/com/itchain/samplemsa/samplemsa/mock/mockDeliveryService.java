package com.itchain.samplemsa.samplemsa.mock;

import com.itchain.samplemsa.samplemsa.order.domain.DeliveryService;

public class mockDeliveryService implements DeliveryService {

    public boolean IsAvailableToCancel(String id) {
        return true;
    }

}
