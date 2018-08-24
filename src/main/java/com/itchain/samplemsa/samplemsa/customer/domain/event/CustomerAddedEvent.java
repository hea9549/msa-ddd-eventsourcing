package com.itchain.samplemsa.samplemsa.customer.domain.event;

import com.itchain.samplemsa.samplemsa.common.Event;
import lombok.Getter;

@Getter
public class CustomerAddedEvent implements Event {
    private String id;
    private String pw;
    private String name;
    private String address;
    private String registeredDay;

    public CustomerAddedEvent(String id, String pw, String name, String address, String registeredDay) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.address = address;
        this.registeredDay = registeredDay;
    }

    @Override
    public String getID() {
        return id;
    }
}