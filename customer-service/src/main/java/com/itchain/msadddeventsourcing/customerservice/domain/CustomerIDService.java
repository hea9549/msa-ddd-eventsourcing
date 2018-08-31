package com.itchain.msadddeventsourcing.customerservice.domain;

import org.springframework.stereotype.Component;

public interface CustomerIDService {
    boolean checkDuplicatedID(String id);
}
