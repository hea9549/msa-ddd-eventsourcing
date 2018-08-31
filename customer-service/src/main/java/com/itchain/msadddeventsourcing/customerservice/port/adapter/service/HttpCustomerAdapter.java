package com.itchain.msadddeventsourcing.customerservice.port.adapter.service;

import com.itchain.msadddeventsourcing.customerservice.web.controller.dto.CustomerInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class HttpCustomerAdapter implements CustomerAdapter{

    @Autowired
    @Qualifier("deliveryRestTemplate")
    RestTemplate deliveryRestTemplate;


    @Override
    public List<CustomerInfoDTO> getAllCustomerList() {
        List<CustomerInfoDTO> customerInfoDTOList = Arrays.asList(deliveryRestTemplate.getForObject("/customers", CustomerInfoDTO[].class));
        return customerInfoDTOList;
    }
}
