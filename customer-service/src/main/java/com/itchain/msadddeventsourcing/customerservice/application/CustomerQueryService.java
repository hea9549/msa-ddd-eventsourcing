package com.itchain.msadddeventsourcing.customerservice.application;

import com.itchain.msadddeventsourcing.customerservice.domain.CustomerInfo;
import com.itchain.msadddeventsourcing.customerservice.port.adapter.persistence.CustomerProjectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerQueryService {

    @Autowired
    private CustomerProjectionRepository customerProjectionRepository;

    public CustomerInfo getCustomerByID(String id) {
        return customerProjectionRepository.findById(id);
    }
}
