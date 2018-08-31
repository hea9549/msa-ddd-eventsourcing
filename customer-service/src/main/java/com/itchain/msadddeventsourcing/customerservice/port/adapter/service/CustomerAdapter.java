package com.itchain.msadddeventsourcing.customerservice.port.adapter.service;

import com.itchain.msadddeventsourcing.customerservice.web.controller.dto.CustomerInfoDTO;

import java.util.List;

public interface CustomerAdapter {
    List<CustomerInfoDTO> getAllCustomerList();
}
