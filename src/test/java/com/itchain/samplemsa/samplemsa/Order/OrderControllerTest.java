package com.itchain.samplemsa.samplemsa.Order;


import com.itchain.samplemsa.samplemsa.TestApplication;
import com.itchain.samplemsa.samplemsa.order.application.OrderApplicationServiceImpl;
import com.itchain.samplemsa.samplemsa.order.domain.Order;
import com.itchain.samplemsa.samplemsa.order.domain.OrderStatus;
import com.itchain.samplemsa.samplemsa.order.web.controller.OrderController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@WebMvcTest(value = OrderController.class, secure = false)
@ContextConfiguration(classes = TestApplication.class)
@AutoConfigureMockMvc
public class OrderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    OrderApplicationServiceImpl tradeApplicationService;

    String exampleCommandJson = "{\"productId\":\"product01\",\"buyerId\":\"buyer01\",\"signedDate\":\"2018-01-01\",\"price\":\"10000\",\"quantity\":\"1\"}";

    @Test
    public void retrieveTrade() throws Exception {

        Order mockOrder = new Order("product01", "buyer01", "2018-01-01", 10000, 1);

        Mockito.when(

                tradeApplicationService.getTradeById(Mockito.anyString())).thenReturn(mockOrder);


        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/trades/{id}", mockOrder.getID()).accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{productId:product01,buyerId:buyer01,signedDate:2018-01-01,price:10000,quantity:1,status:SIGNED}";

        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);

    }

    @Test
    public void createTrade() throws Exception {

        Order mockOrder = new Order("product02", "buyer02", "2018-01-01", 100, 100);

        Mockito.when(
                tradeApplicationService.addTrade(Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyInt(), Mockito.anyInt())).thenReturn(mockOrder);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/trades")
                .accept(MediaType.APPLICATION_JSON).content(exampleCommandJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{productId:product02,buyerId:buyer02,signedDate:2018-01-01,price:100,quantity:100,status:SIGNED}";

        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(), false);
    }

    @Test
    public void cancelTrade() throws Exception {

        Order mockOrder = new Order("product03", "buyer03", "2018-01-01", 10, 10);
        mockOrder.setStatus(OrderStatus.CANCELED);

        Mockito.when(
                tradeApplicationService.cancelTrade(Mockito.anyString())).thenReturn(mockOrder);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/trades/{id}", mockOrder.getID())
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{productId:product03,buyerId:buyer03,signedDate:2018-01-01,price:10,quantity:10,status:CANCELED}";

        System.out.println("test");
        System.out.println(result.getResponse().getContentAsString());

        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);


    }


}
