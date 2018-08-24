package com.itchain.samplemsa.samplemsa.trade.domain;

import org.springframework.stereotype.Service;

@Service
public class ValidateService {

    public boolean IsAvailableToCreate(int requestedAmount, int stock) {
        if (requestedAmount <= stock) {
            return true;
        } else {
            return false;
        }
    }
}
