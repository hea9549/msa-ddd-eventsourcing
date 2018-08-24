package com.itchain.samplemsa.samplemsa.trade.application;

import com.itchain.samplemsa.samplemsa.trade.domain.Trade;

public interface TradeApplicationService {
    void addTrade(String productId, String buyerId, String signedDate, int price, int quantity);
    void cancelTrade(String id);
    Trade getTradeById(String id);
}
