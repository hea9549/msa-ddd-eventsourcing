package com.itchain.samplemsa.samplemsa;

import com.itchain.samplemsa.samplemsa.trade.domain.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

public class mockProductService implements ProductService {

    public int getStockByProductId(String productId){
        return 1;
    }
}
