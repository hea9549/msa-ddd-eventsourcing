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

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public CustomerInfo registerCustomer(@RequestBody CustomerInfoDTO customerInfo) {
        return customerService.registerCustomer(customerInfo.getId(), customerInfo.getPw(), customerInfo.getName(), customerInfo.getAddress());
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    public CustomerInfo withdrawCustomer(@PathVariable String id, @RequestBody CustomerInfoDTO customerInfo) {
        return customerService.withdrawCustomer(id, customerInfo.getPw());
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
    public CustomerInfo updateCustomer(@PathVariable String id, @RequestBody CustomerInfoDTO customerInfo) {
        return customerService.updateCustomer(customerInfo.getId(), customerInfo.getPw(), customerInfo.getName(), customerInfo.getAddress());
    }

    @RequestMapping(value = "/customers/{id}/point", method = RequestMethod.GET)
    public int getCustomerPoint(@PathVariable String id) {
        return customerService.getCustomerPoint(id);
    }
}
