package com.itchain.samplemsa.samplemsa.trade.application;

import com.itchain.samplemsa.samplemsa.trade.TradeRepository;
import com.itchain.samplemsa.samplemsa.trade.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.IllegalTransactionStateException;

@Service
public class TradeApplicationServiceImpl implements TradeApplicationService {

    @Autowired
    TradeRepository tradeRepository;

    @Autowired
    ProductService productService;

    @Autowired
    DeliveryService deliveryService;

    @Autowired
    ValidateService validateService;



    public Trade addTrade(String productId, String buyerId, String signedDate, int price, int quantity) {

        int stock = productService.getStockByProductId(productId);

        // 재고가 남아있다면 저장
        if (validateService.IsAvailableToCreate(quantity, stock)) {
            Trade trade = new Trade(productId, buyerId, signedDate, price, quantity);
            tradeRepository.save(trade);

            return trade;
        } else {
            return null;
        }
    }

    public Trade cancelTrade(String id) {

        Trade trade = tradeRepository.findById(id);

        //배송중, 배송 완료일 경우 취소 불가
        if (deliveryService.IsAvailableToCancel(id)) {

            trade.cancel();

            tradeRepository.save(trade);

            return trade;

        } else {
            return null;
        }
    }

    public Trade getTradeById(String id) {

        Trade trade = tradeRepository.findById(id);

        if (trade.getID() != null) {
            return trade;
        } else {
            throw null;
        }




    }
}
