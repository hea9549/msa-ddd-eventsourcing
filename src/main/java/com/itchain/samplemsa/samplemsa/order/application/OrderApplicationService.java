package com.itchain.samplemsa.samplemsa.order.application;

import com.itchain.samplemsa.samplemsa.order.domain.Order;

public interface OrderApplicationService {
    Order addTrade(String productId, String buyerId, String signedDate, int price, int quantity);
    Order cancelTrade(String id);
    Order getTradeById(String id);
}
