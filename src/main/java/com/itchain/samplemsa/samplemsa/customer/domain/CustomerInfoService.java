package com.itchain.samplemsa.samplemsa.customer.domain;

import com.itchain.samplemsa.samplemsa.customer.domain.dto.CustomerInfoDTO;
import com.itchain.samplemsa.samplemsa.customer.domain.exception.NonIDValueException;
import com.itchain.samplemsa.samplemsa.customer.domain.exception.PasswordTooShortException;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public CustomerInfo removeCustomerInfo(CustomerInfo c, String pw) {
        if (c.checkPassword(pw)) {
            c.removeCustomerInfo(c.getID());
            return c;
        }

        return c;
    }

    public CustomerInfo updateCustomerInfo(CustomerInfo c, String pw, String name, String address) {
        if (pw.length() < 8) {
            throw new PasswordTooShortException();
        }

        c.changeCustomerInfo(pw, name, address);

        return c;
    }

    public int calculatePoint(int spentPrice) {
        return spentPrice / 10;
    }

    public boolean checkDuplicatedID(String id, List<CustomerInfoDTO> customerList) {
        for (CustomerInfoDTO customer : customerList) {
            if (customer.getId().equals(id)) {
                return true;
            }
        }

        return false;
    }
}
