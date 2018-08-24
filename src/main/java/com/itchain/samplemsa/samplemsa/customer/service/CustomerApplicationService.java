package com.itchain.samplemsa.samplemsa.customer.service;

import com.itchain.samplemsa.samplemsa.customer.domain.CustomerInfo;
import com.itchain.samplemsa.samplemsa.customer.domain.CustomerInfoService;
import com.itchain.samplemsa.samplemsa.customer.domain.dto.CustomerDTO;
import com.itchain.samplemsa.samplemsa.customer.domain.exception.DuplicatedIDException;
import com.itchain.samplemsa.samplemsa.customer.infra.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerApplicationService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerInfoService customerInfoService;

    public CustomerInfo getCustomer(String id) {
        return customerRepository.findById(id);
    }

    public void registerCustomer(String id, String pw, String name, String address) {
        // todo : 모든 customer 쿼리
        List<CustomerDTO> customerList = new ArrayList<>();

        if (customerInfoService.checkDuplicatedID(id, customerList)) {
            throw new DuplicatedIDException();
        }

        String registeredDay = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
        CustomerInfo newCustomer = customerInfoService.createCustomerInfo(id, pw, name, address, registeredDay);

        customerRepository.save(newCustomer);
    }

    public void withdrawCustomer(String id, String pw) {
        CustomerInfo customer = customerRepository.findById(id);
        CustomerInfo removedCustomer = customerInfoService.removeCustomerInfo(customer, pw);

        customerRepository.save(removedCustomer);
    }

    public void updateCustomer(String id, String pw, String name, String address) {
        CustomerInfo customer = customerRepository.findById(id);
        CustomerInfo updatedCustomer = customerInfoService.updateCustomerInfo(customer, pw, name, address);

        customerRepository.save(updatedCustomer);
    }

    public int getCustomerPoint(String id) {
        // todo : id로 구매내역 쿼리
        List<Integer> spentPriceList = new ArrayList<Integer>();

        return customerInfoService.calculatePoints(spentPriceList);
    }
}
