package com.itchain.samplemsa.samplemsa.order;


import com.itchain.samplemsa.samplemsa.order.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class OrderProjectionRepository {

    private List<Order> orderList;

    public OrderProjectionRepository() {
        orderList = new ArrayList<>();
    }

    public List<Order> getOrderListByBuyerId(String buyerId) {

        return this.orderList.stream().filter(order -> order.getBuyerId().equals(buyerId)).collect(Collectors.toList());
    }

    public void addOrder(Order order) {
        if (this.orderList.stream().filter(order1 -> order1.getID().equals(order.getID())).findAny().orElse(null) == null) {
            this.orderList.add(order);
        }
    }

    public void deleteOrder(String id) {
        this.orderList.removeIf(order -> order.getID().equals(id));
    }

}
