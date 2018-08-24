package com.itchain.samplemsa.samplemsa.customer.domain.event;

import com.itchain.samplemsa.samplemsa.common.Event;
import lombok.Getter;

@Getter
public class CustomerRemovedEvent implements Event {
    private String id;

    public CustomerRemovedEvent(String id) {
        this.id = id;
    }

    @Override
    public String getID() {
        return id;
    }
}
