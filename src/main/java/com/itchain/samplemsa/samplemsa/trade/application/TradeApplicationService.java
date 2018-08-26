package com.itchain.samplemsa.samplemsa.trade.application;

import com.itchain.samplemsa.samplemsa.trade.domain.Trade;

public interface TradeApplicationService {
    Trade addTrade(String productId, String buyerId, String signedDate, int price, int quantity);
    Trade cancelTrade(String id);
    Trade getTradeById(String id);
}
