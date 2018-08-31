package com.itchain.msadddeventsourcing.orderservice.application;


import com.itchain.msadddeventsourcing.orderservice.domain.Order;

public interface OrderApplicationService {
    Order addTrade(String productId, String buyerId, String signedDate, int price, int quantity);
    Order cancelTrade(String id);
    Order getTradeById(String id);
}
