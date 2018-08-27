package com.itchain.samplemsa.samplemsa.Controller;


import com.itchain.samplemsa.samplemsa.SampleMsaApplication;
import com.itchain.samplemsa.samplemsa.trade.application.TradeApplicationServiceImpl;
import com.itchain.samplemsa.samplemsa.trade.domain.Trade;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.print.attribute.standard.Media;


@RunWith(SpringRunner.class)
@WebMvcTest(value = TradeController.class, secure = false)
@ContextConfiguration(classes = SampleMsaApplication.class)
@AutoConfigureMockMvc
public class TradeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    TradeApplicationServiceImpl tradeApplicationService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    Trade mockTrade = new Trade("product01", "buyer01", "2018-01-01", 10000, 1);


    String exampleCommandJson = "{\"prodoctId\":\"product01\",\"buyerId\":\"buyer01\",\"signedDate\":\"2018-01-01\",\"price\",10000,\"quantity\":1}";


    @Test
    public void retrieveTrade() throws Exception {

        Mockito.when(

                tradeApplicationService.getTradeById(Mockito.anyString())).thenReturn(mockTrade);

//        tradeApplicationService.addTrade(Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyInt(), Mockito.anyInt())


        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/trades/{id}", "11").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{productId:product01,buyerId:buyer01,signedDate:2018-01-01,price:10000,quantity:1,status:SIGNED}";

        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);

        System.out.println(result.getResponse().getHeader(HttpHeaders.LOCATION));

    }

    @Test
    public void createTrade() throws Exception {

        Trade mockTrade = new Trade("1", "11", "21", 10, 10);

        Mockito.when(
                tradeApplicationService.addTrade(Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyInt(), Mockito.anyInt())).thenReturn(mockTrade);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/trades")
                .accept(MediaType.APPLICATION_JSON).content(exampleCommandJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        System.out.println(response.getStatus());

        System.out.println(HttpStatus.CREATED.value());

        System.out.println("kk");

        System.out.println(response.getHeader(HttpHeaders.LOCATION));


    }


}
