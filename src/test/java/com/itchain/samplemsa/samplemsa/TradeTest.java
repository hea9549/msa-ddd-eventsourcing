package com.itchain.samplemsa.samplemsa;

import com.itchain.samplemsa.samplemsa.common.EventRepositoryImpl;
import com.itchain.samplemsa.samplemsa.trade.TradeRepository;
import com.itchain.samplemsa.samplemsa.trade.application.TradeApplicationServiceImpl;
import com.itchain.samplemsa.samplemsa.trade.domain.DeliveryService;
import com.itchain.samplemsa.samplemsa.trade.domain.ProductService;
import com.itchain.samplemsa.samplemsa.trade.domain.Trade;
import com.itchain.samplemsa.samplemsa.trade.domain.TradeStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = MockApplication.class)
@ActiveProfiles("test")
public class TradeTest {

    @Autowired
    private TradeApplicationServiceImpl tradeApplicationService;

    @Autowired
    private ProductService productService;

    @Autowired
    private DeliveryService deliveryService;

    @Test
    public void tradeApplicationService() throws Exception {

        //given
        String productId = "productId";
        String buyerId = "buyerId";
        //ToDo: date 형식 정하기
        String signedDate = "2018-08-25";
        int price = 10000;
        int quantity = 1;



        //ADD TEST

        //when : stock < request quantity
        Mockito.when(productService.getStockByProductId(productId)).thenReturn(0);

        Trade trade1 = tradeApplicationService.addTrade(productId,buyerId,signedDate,price,quantity);

        //then
        Assert.assertNull(trade1);

        //when : requested quantity <= stock
        Mockito.when(productService.getStockByProductId(productId)).thenReturn(1);

        Trade trade = tradeApplicationService.addTrade(productId, buyerId, signedDate, price, quantity);

        //then
        Assert.assertEquals(TradeStatus.SIGNED, trade.getStatus());


        //GET TEST

//        //when : wrong id
//        Trade retrievedTrade1 = tradeApplicationService.getTradeById("random id");
//
//        //then
//        Assert.assertNull(retrievedTrade1);

        //when : right id
        Trade retrievedTrade2 = tradeApplicationService.getTradeById(trade.getID());

        //then
        Assert.assertEquals(trade.getID(), retrievedTrade2.getID());

        //CANCEL TEST

        //when : delivering or delivery is done
        Mockito.when(deliveryService.IsAvailableToCancel(trade.getID())).thenReturn(false);

        Trade canceledTrade1 = tradeApplicationService.cancelTrade(retrievedTrade2.getID());

        Assert.assertNull(canceledTrade1);


        //when : delivery is preparing
        Mockito.when(deliveryService.IsAvailableToCancel(trade.getID())).thenReturn(true);

        Trade canceledTrade2 = tradeApplicationService.cancelTrade(retrievedTrade2.getID());

        //then
        Assert.assertEquals(retrievedTrade2.getID(), canceledTrade2.getID());

        Assert.assertEquals(TradeStatus.CANCELED, canceledTrade2.getStatus());

    }

}
