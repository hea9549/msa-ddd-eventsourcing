package com.itchain.samplemsa.samplemsa.order.domain.event;

import com.itchain.samplemsa.samplemsa.common.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderDeletedEvent implements Event {
    private String id;

    @Override
    public String getID() {
        return id;
    }
}
