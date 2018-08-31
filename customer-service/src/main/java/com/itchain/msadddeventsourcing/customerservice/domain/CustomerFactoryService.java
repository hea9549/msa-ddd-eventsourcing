package com.itchain.msadddeventsourcing.customerservice.domain;

import com.itchain.msadddeventsourcing.customerservice.domain.exception.NonIDValueException;
import com.itchain.msadddeventsourcing.customerservice.domain.exception.PasswordTooShortException;
import org.springframework.stereotype.Component;

@Component
public class CustomerFactoryService {

    public CustomerInfo createCustomerInfo(String id, String pw, String name, String address, String registeredDay) {
        if (id.length() == 0) {
            throw new NonIDValueException();
        }

        if (pw.length() < 8) {
            throw new PasswordTooShortException();
        }

        return new CustomerInfo(id, pw, name, address, registeredDay);
    }
}
