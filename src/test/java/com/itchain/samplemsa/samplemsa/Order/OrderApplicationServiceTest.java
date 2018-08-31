package com.itchain.samplemsa.samplemsa.Order;

import com.itchain.samplemsa.samplemsa.TestApplication;
import com.itchain.samplemsa.samplemsa.order.application.OrderApplicationServiceImpl;
import com.itchain.samplemsa.samplemsa.order.domain.DeliveryService;
import com.itchain.samplemsa.samplemsa.order.domain.Order;
import com.itchain.samplemsa.samplemsa.order.domain.ProductService;
import com.itchain.samplemsa.samplemsa.order.domain.OrderStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = TestApplication.class)
@ActiveProfiles("test")
public class OrderApplicationServiceTest {

    @Autowired
    private OrderApplicationServiceImpl tradeApplicationService;

    @Autowired
    private ProductService productService;

    @Autowired
    private DeliveryService deliveryService;

    @Test
    public void OrderApplicationService() throws Exception {

        //given
        String productId = "productId";
        String buyerId = "buyerId";
        //ToDo: date 형식 정하기
        String signedDate = "2018-08-25";
        int price = 10000;
        int quantity = 1;



        //ADD TEST

        //when : stock < request stock
        Mockito.when(productService.getStockByProductId(productId)).thenReturn(0);

        Order order1 = tradeApplicationService.addTrade(productId,buyerId,signedDate,price,quantity);

        //then
        Assert.assertNull(order1);

        //when : requested stock <= stock
        Mockito.when(productService.getStockByProductId(productId)).thenReturn(1);

        Order order = tradeApplicationService.addTrade(productId, buyerId, signedDate, price, quantity);

        //then
        Assert.assertEquals(OrderStatus.SIGNED, order.getStatus());


        //GET TEST

        //ToDo: bug fix - wrong id로 입력 시 null 반환
//        //when : wrong id
//        Order retrievedTrade1 = tradeApplicationService.getTradeById("random id");
//
//        //then
//        Assert.assertNull(retrievedTrade1);

        //when : right id
        Order retrievedOrder2 = tradeApplicationService.getTradeById(order.getID());

        //then
        Assert.assertEquals(order.getID(), retrievedOrder2.getID());

        //CANCEL TEST

        //when : delivering or delivery is done
        Mockito.when(deliveryService.IsAvailableToCancel(order.getID())).thenReturn(false);

        Order canceledOrder1 = tradeApplicationService.cancelTrade(retrievedOrder2.getID());

        Assert.assertNull(canceledOrder1);


        //when : delivery is preparing
        Mockito.when(deliveryService.IsAvailableToCancel(order.getID())).thenReturn(true);

        Order canceledOrder2 = tradeApplicationService.cancelTrade(retrievedOrder2.getID());

        //then
        Assert.assertEquals(retrievedOrder2.getID(), canceledOrder2.getID());

        Assert.assertEquals(OrderStatus.CANCELED, canceledOrder2.getStatus());

    }

}
