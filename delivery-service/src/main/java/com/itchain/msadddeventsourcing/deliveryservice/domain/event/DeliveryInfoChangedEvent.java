package com.itchain.msadddeventsourcing.deliveryservice.domain.event;

import com.itchain.msadddeventsourcing.deliveryservice.common.Event;
import com.itchain.msadddeventsourcing.deliveryservice.domain.DeliverStatus;
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
