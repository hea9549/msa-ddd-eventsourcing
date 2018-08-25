package com.itchain.samplemsa.samplemsa.customer.port.adapter.service;

import com.itchain.samplemsa.samplemsa.customer.domain.dto.TradeInfoDTO;

import java.util.List;

public interface TradeAdapter {
    List<TradeInfoDTO> getTradeListByCustomerID(String id);
}
