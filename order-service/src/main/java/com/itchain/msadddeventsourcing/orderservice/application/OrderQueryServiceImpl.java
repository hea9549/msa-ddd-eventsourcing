package com.itchain.msadddeventsourcing.orderservice.application;

import com.itchain.msadddeventsourcing.orderservice.domain.Order;
import com.itchain.msadddeventsourcing.orderservice.port.adapter.persistence.OrderProjectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderQueryServiceImpl implements OrderQueryService {

    @Autowired
    private OrderProjectionRepository orderProjectionRepository;

    @Override
    public Order getOrderById(String orderId) {
        return this.orderProjectionRepository.getOrderById(orderId);
    }

    @Override
    public List<Order> getOrderListByBuyerId(String buyerId) {
        List<Order> OrderList = this.orderProjectionRepository.getOrderList();

        return OrderList.stream().filter(order -> order.getBuyerId().equals(buyerId)).collect(Collectors.toList());
    }
}
