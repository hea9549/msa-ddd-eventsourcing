package com.itchain.samplemsa.samplemsa.Controller;


import com.itchain.samplemsa.samplemsa.MockApplication;
import com.itchain.samplemsa.samplemsa.SampleMsaApplication;
import com.itchain.samplemsa.samplemsa.trade.application.TradeApplicationServiceImpl;
import com.itchain.samplemsa.samplemsa.trade.domain.Trade;
import com.itchain.samplemsa.samplemsa.trade.domain.TradeStatus;
import com.itchain.samplemsa.samplemsa.trade.web.controller.TradeController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.print.attribute.standard.Media;


@RunWith(SpringRunner.class)
@WebMvcTest(value = TradeController.class, secure = false)
@ContextConfiguration(classes = MockApplication.class)
@AutoConfigureMockMvc
public class TradeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    TradeApplicationServiceImpl tradeApplicationService;

    String exampleCommandJson = "{\"productId\":\"product01\",\"buyerId\":\"buyer01\",\"signedDate\":\"2018-01-01\",\"price\":\"10000\",\"quantity\":\"1\"}";

    @Test
    public void retrieveTrade() throws Exception {

        Trade mockTrade = new Trade("product01", "buyer01", "2018-01-01", 10000, 1);

        Mockito.when(

                tradeApplicationService.getTradeById(Mockito.anyString())).thenReturn(mockTrade);

//        tradeApplicationService.addTrade(Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyInt(), Mockito.anyInt())


        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/trades/{id}", mockTrade.getID()).accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{productId:product01,buyerId:buyer01,signedDate:2018-01-01,price:10000,quantity:1,status:SIGNED}";

        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);

    }

    @Test
    public void createTrade() throws Exception {

        Trade mockTrade = new Trade("product02", "buyer02", "2018-01-01", 100, 100);

        Mockito.when(
                tradeApplicationService.addTrade(Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyInt(), Mockito.anyInt())).thenReturn(mockTrade);

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

        Trade mockTrade = new Trade("product03", "buyer03", "2018-01-01", 10, 10);
        mockTrade.setStatus(TradeStatus.CANCELED);

        Mockito.when(
                tradeApplicationService.cancelTrade(Mockito.anyString())).thenReturn(mockTrade);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/trades/{id}",mockTrade.getID())
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{productId:product03,buyerId:buyer03,signedDate:2018-01-01,price:10,quantity:10,status:CANCELED}";

        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);


    }


}
