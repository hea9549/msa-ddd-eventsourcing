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



    public void addTrade(String productId, String buyerId, String signedDate, int price, int quantity) {

        int stock = productService.getStockByProductId(productId);

        // 재고가 남아있다면 저장
        if (validateService.IsAvailableToCreate(quantity, stock)) {
            Trade trade = new Trade(productId, buyerId, signedDate, price, quantity);
            tradeRepository.save(trade);
        } else {
            //ToDo: 이 에러가 맞는 지 확인.
            throw new NullPointerException();
        }
    }

    public void cancelTrade(String id) {

        Trade trade = tradeRepository.findById(id);

        //배송중, 배송 완료일 경우 취소 불가
        if (deliveryService.IsAvailableToCancel(id)) {

            trade.cancel();

            tradeRepository.save(trade);

        } else {
            throw new NullPointerException();

        }
    }

    public Trade getTradeById(String id) {

        Trade trade = tradeRepository.findById(id);

        //repo에 trade가 있으면 조회, 없으면 에러 throw
        //ToDo: 이렇게 구현하는 게 맞는 지 확인
        if (trade.getID() != null) {
            return trade;
        } else {
            throw new NullPointerException();
        }




    }
}
