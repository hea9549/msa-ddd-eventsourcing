package com.itchain.samplemsa.samplemsa.customer.port.adapter.service;

import com.itchain.samplemsa.samplemsa.customer.domain.CustomerPriceService;
import com.itchain.samplemsa.samplemsa.customer.domain.TradeStatus;
import com.itchain.samplemsa.samplemsa.customer.domain.dto.TradeInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerPriceServiceImpl implements CustomerPriceService {
    @Autowired
    private TradeAdapter tradeAdapter;

    @Override
    public int getPriceOfSignedTrades(String customerID) {
        int totalPrice = 0;

        List<TradeInfoDTO> tradeInfoDTOList = tradeAdapter.getTradeListByCustomerID(customerID);

        for (TradeInfoDTO trade : tradeInfoDTOList) {
            if (trade.getStatus().equals(TradeStatus.SIGNED)) {
                totalPrice += trade.getPrice() * trade.getQuantity();
            }
        }

        return totalPrice;
    }

}
