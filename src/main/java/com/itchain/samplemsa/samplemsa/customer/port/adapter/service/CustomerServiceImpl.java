package com.itchain.samplemsa.samplemsa.customer.port.adapter.service;

import com.itchain.samplemsa.samplemsa.customer.domain.CustomerService;
import com.itchain.samplemsa.samplemsa.customer.domain.dto.CustomerInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private HttpCustomerAdapter httpCustomerAdapter;

    @Override
    public boolean checkDuplicatedID(String id) {
        List<CustomerInfoDTO> customerInfoDTOList = httpCustomerAdapter.getAllCustomerList();

        for (CustomerInfoDTO customer : customerInfoDTOList) {
            if(id.equals(customer.getId())) {
                return true;
            }
        }

        return false;
    }
}
