package com.itchain.msadddeventsourcing.customerservice.application;


import com.itchain.msadddeventsourcing.customerservice.domain.CustomerFactoryService;
import com.itchain.msadddeventsourcing.customerservice.domain.CustomerIDService;
import com.itchain.msadddeventsourcing.customerservice.domain.CustomerInfo;
import com.itchain.msadddeventsourcing.customerservice.domain.CustomerPriceService;
import com.itchain.msadddeventsourcing.customerservice.domain.exception.DuplicatedIDException;
import com.itchain.msadddeventsourcing.customerservice.port.adapter.persistence.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerApplicationService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerFactoryService customerFactoryService;

    @Autowired
    private CustomerIDService customerIDService;

    public CustomerInfo getCustomerByID(String id) {
        return customerRepository.findById(id);
    }

    public CustomerInfo registerCustomer(String id, String pw, String name, String address) {
        if (customerIDService.checkDuplicatedID(id)) {
            throw new DuplicatedIDException();
        }

        String registeredDay = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
        CustomerInfo newCustomer = customerFactoryService.createCustomerInfo(id, pw, name, address, registeredDay);

        customerRepository.save(newCustomer);
        return newCustomer;
    }

    public CustomerInfo withdrawCustomer(String id, String pw) {
        CustomerInfo customer = customerRepository.findById(id);
        customer.removeCustomerInfo(id, pw);

        customerRepository.save(customer);
        return customer;
    }

    public CustomerInfo updateCustomer(String id, String pw, String name, String address) {
        CustomerInfo customer = customerRepository.findById(id);
        customer.changeCustomerInfo(pw, name, address);

        customerRepository.save(customer);
        return customer;
    }
}