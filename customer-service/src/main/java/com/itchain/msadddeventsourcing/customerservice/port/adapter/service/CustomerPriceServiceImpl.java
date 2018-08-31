package com.itchain.msadddeventsourcing.customerservice.port.adapter.service;


import com.itchain.msadddeventsourcing.customerservice.domain.CustomerPriceService;
import com.itchain.msadddeventsourcing.customerservice.domain.TradeStatus;
import com.itchain.msadddeventsourcing.customerservice.web.controller.dto.OrderInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerPriceServiceImpl implements CustomerPriceService {

    @Autowired
    private OrderAdapter orderAdapter;

    @Override
    public int getPriceOfSignedTrades(String customerID) {

        int totalPrice = 0;
        List<OrderInfoDTO> orderInfoDTOList = orderAdapter.getTradeListByCustomerID(customerID);

        for (OrderInfoDTO trade : orderInfoDTOList) {
            if (trade.getStatus().equals(TradeStatus.SIGNED)) {
                totalPrice += trade.getPrice() * trade.getQuantity();
            }
        }

        return totalPrice;
    }

}
