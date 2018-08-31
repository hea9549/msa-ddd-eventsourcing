package com.itchain.msadddeventsourcing.customerservice.port.adapter.service;

import com.itchain.msadddeventsourcing.customerservice.web.controller.dto.OrderInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

@Component
public class HttpOrderAdapter implements OrderAdapter {

    @Autowired
    @Qualifier("orderRestTemplate")
    RestTemplate customerRestTemplate;

    @Override
    public List<OrderInfoDTO> getTradeListByCustomerID(String id) {

        @NotNull
        List<OrderInfoDTO> orderInfoDTOList = Arrays.asList(customerRestTemplate.getForObject("/orders", OrderInfoDTO[].class));
        return orderInfoDTOList;
    }
}
