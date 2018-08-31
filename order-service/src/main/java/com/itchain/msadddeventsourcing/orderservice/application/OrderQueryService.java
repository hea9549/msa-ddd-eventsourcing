package com.itchain.msadddeventsourcing.orderservice.application;

import com.itchain.msadddeventsourcing.orderservice.domain.Order;

import java.util.List;

public interface OrderQueryService {
    List<Order> getOrderListByBuyerId(String buyerId);
    Order getOrderById(String orderId);
}
