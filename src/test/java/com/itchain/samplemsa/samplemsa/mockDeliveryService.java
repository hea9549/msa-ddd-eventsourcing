package com.itchain.samplemsa.samplemsa;

import com.itchain.samplemsa.samplemsa.trade.domain.DeliveryService;

public class mockDeliveryService implements DeliveryService {

    public boolean IsAvailableToCancel(String id) {
        return true;
    }

}
