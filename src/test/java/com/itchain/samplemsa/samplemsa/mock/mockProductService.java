package com.itchain.samplemsa.samplemsa.mock;

import com.itchain.samplemsa.samplemsa.trade.domain.ProductService;

public class mockProductService implements ProductService {

    public int getStockByProductId(String productId){
        return 1;
    }
}
