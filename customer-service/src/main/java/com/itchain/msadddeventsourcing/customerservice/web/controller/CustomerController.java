package com.itchain.msadddeventsourcing.customerservice.web.controller;


import com.itchain.msadddeventsourcing.customerservice.application.CustomerApplicationService;
import com.itchain.msadddeventsourcing.customerservice.application.CustomerQueryService;
import com.itchain.msadddeventsourcing.customerservice.domain.CustomerInfo;
import com.itchain.msadddeventsourcing.customerservice.web.controller.dto.CustomerInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class CustomerController {

    @Autowired
    private CustomerApplicationService customerService;

    @Autowired
    private CustomerQueryService customerQueryService;

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public CustomerInfo getCustomer(@PathVariable String id) {
        return customerQueryService.getCustomerByID(id);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.POST)
    public CustomerInfo registerCustomer(@PathVariable String id, @RequestBody CustomerInfoDTO customerInfo) {
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

//    @RequestMapping(value = "/customers/{id}/point", method = RequestMethod.GET)
//    public int getCustomerPoint(@PathVariable String id) {
//        return customerService.getCustomerPoint(id);
//    }
}
