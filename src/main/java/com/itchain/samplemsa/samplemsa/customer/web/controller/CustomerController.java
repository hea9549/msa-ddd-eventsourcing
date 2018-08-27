package com.itchain.samplemsa.samplemsa.customer.web.controller;

import com.itchain.samplemsa.samplemsa.customer.domain.CustomerInfo;
import com.itchain.samplemsa.samplemsa.customer.domain.dto.CustomerInfoDTO;
import com.itchain.samplemsa.samplemsa.customer.application.CustomerApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@RestController
//public class CustomerController {
//    @Autowired
//    private CustomerApplicationService customerService;
//
//    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public CustomerInfo getCustomer(@PathVariable("id") String id) {
//        return customerService.getCustomer(id);
//    }
//
//    @RequestMapping(value = "/customers/register-customer/{customerInfo}", method = RequestMethod.POST)
//    public void registerCustomer(@RequestParam(required = true) CustomerInfoDTO customerInfo) {
//        customerService.registerCustomer(customerInfo.getId(), customerInfo.getPw(), customerInfo.getName(), customerInfo.getAddress());
//    }
//
//    @RequestMapping(value = "/customers/remove-customer/{customerInfo}", method = RequestMethod.POST)
//    public void withdrawCustomer(@RequestParam(required = true) CustomerInfoDTO customerInfo) {
//        customerService.withdrawCustomer(customerInfo.getId(), customerInfo.getPw());
//    }
//
//    @RequestMapping(value = "/customers/edit-customer/{customerInfo}", method = RequestMethod.POST)
//    public void updateCustomer(@RequestParam(required = true) CustomerInfoDTO customerInfo) {
//        customerService.updateCustomer(customerInfo.getId(), customerInfo.getPw(), customerInfo.getName(), customerInfo.getAddress());
//    }
//
//    @RequestMapping(value = "/customers/get-point/{id}", method = RequestMethod.POST)
//    public int getCustomerPoint(@RequestParam(required = true) String id) {
//        return customerService.getCustomerPoint(id);
//    }
//}
