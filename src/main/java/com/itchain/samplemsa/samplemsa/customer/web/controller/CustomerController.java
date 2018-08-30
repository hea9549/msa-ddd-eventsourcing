package com.itchain.samplemsa.samplemsa.customer.web.controller;

import com.itchain.samplemsa.samplemsa.customer.domain.CustomerInfo;
import com.itchain.samplemsa.samplemsa.customer.domain.dto.CustomerInfoDTO;
import com.itchain.samplemsa.samplemsa.customer.application.CustomerApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class CustomerController {
    @Autowired
    private CustomerApplicationService customerService;

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CustomerInfo getCustomer(@PathVariable String id) {
        return customerService.getCustomerByID(id);
    }

    @RequestMapping(value = "/customers/register-customer", method = RequestMethod.POST)
    public CustomerInfo registerCustomer(@RequestBody CustomerInfoDTO customerInfo) {
        CustomerInfo newCustomer = customerService.registerCustomer(customerInfo.getId(), customerInfo.getPw(), customerInfo.getName(), customerInfo.getAddress());
        return newCustomer;
    }

    @RequestMapping(value = "/customers/remove-customer/{customerInfo}", method = RequestMethod.POST)
    public void withdrawCustomer(@PathVariable CustomerInfoDTO customerInfo) {
        customerService.withdrawCustomer(customerInfo.getId(), customerInfo.getPw());
    }

    @RequestMapping(value = "/customers/edit-customer/{customerInfo}", method = RequestMethod.POST)
    public void updateCustomer(@PathVariable CustomerInfoDTO customerInfo) {
        customerService.updateCustomer(customerInfo.getId(), customerInfo.getPw(), customerInfo.getName(), customerInfo.getAddress());
    }

    @RequestMapping(value = "/customers/get-point/{id}", method = RequestMethod.POST)
    public int getCustomerPoint(@PathVariable String id) {
        return customerService.getCustomerPoint(id);
    }
}
