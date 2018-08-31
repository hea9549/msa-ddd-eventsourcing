package com.itchain.msadddeventsourcing.customerservice.domain.event;

import com.itchain.msadddeventsourcing.customerservice.common.Event;
import lombok.Getter;

@Getter
public class CustomerUpdatedEvent implements Event {
    private String id;
    private String pw;
    private String name;
    private String address;

    public CustomerUpdatedEvent(String id, String pw, String name, String address) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.address = address;
    }

    @Override
    public String getID() {
        return id;
    }
}
