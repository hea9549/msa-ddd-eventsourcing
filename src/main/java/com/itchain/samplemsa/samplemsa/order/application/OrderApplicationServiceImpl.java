package com.itchain.samplemsa.samplemsa.order.application;

import com.itchain.samplemsa.samplemsa.order.OrderRepository;
import com.itchain.samplemsa.samplemsa.order.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderApplicationServiceImpl implements OrderApplicationService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductService productService;

    @Autowired
    DeliveryService deliveryService;

    @Autowired
    ValidateService validateService;



    public Order addTrade(String productId, String buyerId, String signedDate, int price, int quantity) {

        int stock = productService.getStockByProductId(productId);

        if (validateService.IsAvailableToCreate(quantity, stock)) {
            Order order = new Order(productId, buyerId, signedDate, price, quantity);
            orderRepository.save(order);

            return order;
        } else {
            return null;
        }
    }

    public Order cancelTrade(String id) {

        Order order = orderRepository.findById(id);

        //배송중, 배송 완료일 경우 취소 불가
        if (deliveryService.IsAvailableToCancel(id)) {

            order.cancel();

            orderRepository.save(order);

            return order;

        } else {
            return null;
        }
    }

    public Order getTradeById(String id) {

        Order order = orderRepository.findById(id);

        if (order.getID() != null) {
            return order;
        } else {
            throw null;
        }
    }
}
