package com.itchain.samplemsa.samplemsa.delivery.domain.event;

import com.itchain.samplemsa.samplemsa.common.Event;
import com.itchain.samplemsa.samplemsa.delivery.domain.DeliverStatus;
import com.itchain.samplemsa.samplemsa.trade.domain.DeliverStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DeliveryInfoChangedEvent implements Event {
    private String id;
    private DeliverStatus status;

    @Override
    public String getID() {
        return id;
    }

}
