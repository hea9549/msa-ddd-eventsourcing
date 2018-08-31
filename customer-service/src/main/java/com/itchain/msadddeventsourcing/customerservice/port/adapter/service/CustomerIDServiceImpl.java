package com.itchain.msadddeventsourcing.customerservice.port.adapter.service;


import com.itchain.msadddeventsourcing.customerservice.domain.CustomerIDService;
import com.itchain.msadddeventsourcing.customerservice.web.controller.dto.CustomerInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerIDServiceImpl implements CustomerIDService {

    @Autowired
    private CustomerAdapter customerAdapter;

    @Override
    public boolean checkDuplicatedID(String id) {
        List<CustomerInfoDTO> customerInfoDTOList = customerAdapter.getAllCustomerList();

        for (CustomerInfoDTO customer : customerInfoDTOList) {
            if(id.equals(customer.getId())) {
                return true;
            }
        }
        return false;
    }
}
