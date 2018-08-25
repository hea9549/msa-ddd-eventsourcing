package com.itchain.samplemsa.samplemsa.customer.port.adapter.service;

import com.itchain.samplemsa.samplemsa.customer.domain.dto.CustomerInfoDTO;

import java.util.List;

public interface CustomerAdapter {
    List<CustomerInfoDTO> getAllCustomerList();
}
