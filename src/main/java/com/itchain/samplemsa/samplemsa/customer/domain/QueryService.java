package com.itchain.samplemsa.samplemsa.customer.domain;

import com.itchain.samplemsa.samplemsa.customer.domain.dto.CustomerDTO;

import java.util.List;

public interface QueryService {
    CustomerDTO getCustomerInfo(String id);
    List<CustomerDTO> getCustomerInfos();
}
