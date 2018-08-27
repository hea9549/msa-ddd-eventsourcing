package com.itchain.samplemsa.samplemsa;

import com.itchain.samplemsa.samplemsa.trade.application.TradeApplicationServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TradeTest {

    @Autowired
    TradeApplicationServiceImpl tradeApplicationService;

//    @Test
//    public void tradeTest() {
//        Trade trade = new Trade("product","buyer", "2018-08-20",10000,1);
//        tradeRepository.save(trade);
//        Trade retrivedTrade = tradeRepository.findById(trade.getID());
//        System.out.println(retrivedTrade.getID());
//        System.out.println(retrivedTrade.getProductId());
//
//    }

    @Test
    public void tradeApplicationService() {
        tradeApplicationService.addTrade("product", "buyer", "2018-08-20",10000,1);

    }

}
