package com.itchain.samplemsa.samplemsa.customer.controller;

import com.itchain.samplemsa.samplemsa.customer.domain.CustomerInfo;
import com.itchain.samplemsa.samplemsa.customer.domain.dto.CustomerDTO;
import com.itchain.samplemsa.samplemsa.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CustomerInfo getCustomer(@PathVariable("id") String id) {
        return customerService.getCustomerInfo(id);
    }

    @RequestMapping(value = "/customers/register-customer/{customerInfo}", method = RequestMethod.POST)
    public void registerCustomer(@RequestParam(required = true) CustomerDTO customerInfo) {
        customerService.createCustomerInfo(customerInfo.getId(), customerInfo.getPw(), customerInfo.getName(), customerInfo.getAddress());
    }

    @RequestMapping(value = "/customers/remove-customer/{customerInfo}", method = RequestMethod.POST)
    public void removeCustomer(@RequestParam(required = true) CustomerDTO customerInfo) {
        customerService.removeCustomerInfo(customerInfo.getId(), customerInfo.getPw());
    }

    @RequestMapping(value = "/customers/edit-customer/{customerInfo}", method = RequestMethod.POST)
    public void editCustomerInfo(@RequestParam(required = true) CustomerDTO customerInfo) {
        customerService.updateCustomerInfo(customerInfo.getId(), customerInfo.getPw(), customerInfo.getName(), customerInfo.getAddress());
    }

    @RequestMapping(value = "/customers/get-point/{id}", method = RequestMethod.POST)
    public int getCustomerPoint(@RequestParam(required = true) String id) {
        return customerService.calculatePoints(id);
    }
}
