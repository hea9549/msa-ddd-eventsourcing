package com.itchain.samplemsa.samplemsa.customer.port.adapter.service;

import com.itchain.samplemsa.samplemsa.customer.domain.dto.CustomerInfoDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class HttpCustomerAdapter implements CustomerAdapter{
    private static final String HOST = "localhost";
    private static final String PORT = "8080";
    private static final String PROTOCOL = "http";
    private static final String TEMPLATE = "/customer";


    @Override
    public List<CustomerInfoDTO> getAllCustomerList() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = PROTOCOL + "://" + HOST + ":" + PORT + TEMPLATE;

        List<CustomerInfoDTO> customerInfoDTOList = Arrays.asList(restTemplate.getForObject(uri, CustomerInfoDTO[].class));
        return customerInfoDTOList;
    }
}
