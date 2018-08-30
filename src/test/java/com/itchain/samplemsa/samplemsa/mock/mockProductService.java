package com.itchain.samplemsa.samplemsa.mock;

import com.itchain.samplemsa.samplemsa.order.domain.ProductService;

public class mockProductService implements ProductService {

    public int getStockByProductId(String productId){
        return 1;
    }
}
