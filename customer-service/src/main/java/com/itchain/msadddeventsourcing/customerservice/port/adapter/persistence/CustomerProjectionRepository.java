package com.itchain.msadddeventsourcing.customerservice.port.adapter.persistence;

import com.itchain.msadddeventsourcing.customerservice.domain.CustomerInfo;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerProjectionRepository {
    public CustomerInfo findById(String id){
        return null;
    }
}
