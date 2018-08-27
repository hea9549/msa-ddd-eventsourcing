package com.itchain.samplemsa.samplemsa.customer.application;

import com.itchain.samplemsa.samplemsa.customer.domain.CustomerInfo;
import com.itchain.samplemsa.samplemsa.customer.domain.CustomerInfoService;
import com.itchain.samplemsa.samplemsa.customer.domain.CustomerService;
import com.itchain.samplemsa.samplemsa.customer.domain.TradeService;
import com.itchain.samplemsa.samplemsa.customer.domain.exception.DuplicatedIDException;
import com.itchain.samplemsa.samplemsa.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CustomerApplicationService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerInfoService customerInfoService;

    @Autowired
    private TradeService tradeService;

    @Autowired
    private CustomerService customerService;

    public CustomerInfo getCustomer(String id) {
        return customerRepository.findById(id);
    }

    public CustomerInfo registerCustomer(String id, String pw, String name, String address) {
        if (customerService.checkDuplicatedID(id)) {
            throw new DuplicatedIDException();
        }

        String registeredDay = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
        CustomerInfo newCustomer = customerInfoService.createCustomerInfo(id, pw, name, address, registeredDay);

        customerRepository.save(newCustomer);
        return newCustomer;
    }

    public void withdrawCustomer(String id, String pw) {
        CustomerInfo customer = customerRepository.findById(id);
        customer.removeCustomerInfo(id, pw);

        customerRepository.save(customer);
    }

    public CustomerInfo updateCustomer(String id, String pw, String name, String address) {
        CustomerInfo customer = customerRepository.findById(id);
        customer.changeCustomerInfo(pw, name, address);

        customerRepository.save(customer);
        return customer;
    }

    public int getCustomerPoint(String id) {
        int spentPrice = tradeService.getPriceOfSignedTrades(id);

        return spentPrice / 10;
    }
}
