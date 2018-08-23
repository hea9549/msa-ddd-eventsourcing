package com.itchain.samplemsa.samplemsa.customer.service;

import com.itchain.samplemsa.samplemsa.customer.domain.CustomerInfo;
import com.itchain.samplemsa.samplemsa.customer.domain.exception.NonIDValueException;
import com.itchain.samplemsa.samplemsa.customer.domain.exception.PasswordTooShortException;
import com.itchain.samplemsa.samplemsa.customer.infra.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerInfo getCustomerInfo(String id) {
        CustomerInfo c = customerRepository.findById(id);

        return c;
    }

    public void createCustomerInfo(String id, String pw, String name, String address) {
        if (id.length() == 0) {
            throw new NonIDValueException();
        }

        if (pw.length() < 8) {
            throw new PasswordTooShortException();
        }

        String registeredDay = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());

        CustomerInfo c = new CustomerInfo(id, pw, name, address, registeredDay);

        customerRepository.save(c);
    }

    public void removeCustomerInfo(String id, String pw) {
        CustomerInfo c = customerRepository.findById(id);
        if (c.checkPassword(pw)) {
            customerRepository.save(c);
        }
    }

    public void updateCustomerInfo(String id, String pw, String name, String address) {
        if (pw.length() == 0) {
            throw new PasswordTooShortException();
        }

        CustomerInfo c = customerRepository.findById(id);

        customerRepository.save(c);
    }

    public int calculatePoints(String id) {
        int point = 0;

        // todo : 구매내역 쿼리
        List<Integer> spentPriceList = new ArrayList<Integer>();

        for (int price : spentPriceList) {
            point += price;
        }

        return point;
    }
}
