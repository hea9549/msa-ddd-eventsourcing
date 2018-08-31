package com.itchain.msadddeventsourcing.customerservice.domain;


import com.itchain.msadddeventsourcing.customerservice.common.Aggregate;
import com.itchain.msadddeventsourcing.customerservice.common.Event;
import com.itchain.msadddeventsourcing.customerservice.common.OnEvent;
import com.itchain.msadddeventsourcing.customerservice.domain.event.CustomerAddedEvent;
import com.itchain.msadddeventsourcing.customerservice.domain.event.CustomerRemovedEvent;
import com.itchain.msadddeventsourcing.customerservice.domain.event.CustomerUpdatedEvent;
import com.itchain.msadddeventsourcing.customerservice.domain.exception.PasswordNotMatchedException;
import com.itchain.msadddeventsourcing.customerservice.domain.exception.PasswordTooShortException;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.List;

@NoArgsConstructor
@ToString
public class CustomerInfo extends Aggregate {

    @Id
    private String id;
    private String pw;
    private String name;
    private String address;
    private String registeredDay;

    public CustomerInfo(String id, String pw, String name, String address, String registeredDay) {
        this.apply(new CustomerAddedEvent(id, pw, name, address, registeredDay));
    }

    public CustomerInfo(List<Event> eventList) {
        super(eventList);
    }

    @Override
    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getRegisteredDay() {
        return registeredDay;
    }

    public boolean checkPassword(String pw) {
        if (pw.equals(this.pw)) {
            return true;
        }

        return false;
    }

    public void changeCustomerInfo(String pw, String name, String address) {
        if (pw.length() < 8) {
            throw new PasswordTooShortException();
        }

        this.apply(new CustomerUpdatedEvent(this.id, pw, name, address));
    }

    public void removeCustomerInfo(String id, String pw) {
        if (!this.pw.equals(pw)) {
            throw new PasswordNotMatchedException();
        }

        this.apply(new CustomerRemovedEvent(id));
    }

    @OnEvent
    private void onCustomerAddedEvent(CustomerAddedEvent event) {
        this.id = event.getID();
        this.pw = event.getPw();
        this.name = event.getName();
        this.address = event.getAddress();
        this.registeredDay = event.getRegisteredDay();
    }

    @OnEvent
    private void onCustomerRemovedEvent(CustomerRemovedEvent event) {
        this.id = "";
        this.pw = "";
        this.name = "";
        this.address = "";
        this.registeredDay = "";
    }

    @OnEvent
    private void onCustomerUpdatedEvent(CustomerUpdatedEvent event) {
        this.pw = event.getPw();
        this.name = event.getName();
        this.address = event.getAddress();
    }
}
