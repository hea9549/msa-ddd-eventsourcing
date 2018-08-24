package com.itchain.samplemsa.samplemsa.trade.port.adapter.service;

import com.itchain.samplemsa.samplemsa.trade.domain.dto.ProductInfoDTO;

public interface ProductAdapter {
    public int getStockByProductId(String productId);
}
