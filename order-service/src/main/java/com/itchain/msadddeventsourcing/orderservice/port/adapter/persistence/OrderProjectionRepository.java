package com.itchain.msadddeventsourcing.orderservice.port.adapter.persistence;


import com.itchain.msadddeventsourcing.orderservice.domain.Order;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Repository
public class OrderProjectionRepository {

    private List<Order> orderList;

    public OrderProjectionRepository() {
        orderList = new ArrayList<>();
    }

    public void addOrder(Order order) {
        if (this.orderList.stream().filter(order1 -> order1.getID().equals(order.getID())).findAny().orElse(null) == null) {
            this.orderList.add(order);
        }
    }

    public void deleteOrder(String id) {
        this.orderList.removeIf(order -> order.getID().equals(id));
    }

    public Order getOrderById(String orderId) {
        return orderList.stream().filter(order -> orderId.equals(order.getID())).findAny().orElse(null);
    }
}
