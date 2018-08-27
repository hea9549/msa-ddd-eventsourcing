package com.itchain.samplemsa.samplemsa.customer.domain;

import com.itchain.samplemsa.samplemsa.customer.domain.exception.NonIDValueException;
import com.itchain.samplemsa.samplemsa.customer.domain.exception.PasswordTooShortException;
import org.springframework.stereotype.Component;

@Component
public class CustomerInfoService {
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
