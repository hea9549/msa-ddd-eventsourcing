package com.itchain.samplemsa.samplemsa.customer;

import com.itchain.samplemsa.samplemsa.TestApplication;
import com.itchain.samplemsa.samplemsa.customer.application.CustomerApplicationService;
import com.itchain.samplemsa.samplemsa.customer.domain.CustomerInfo;
import com.itchain.samplemsa.samplemsa.customer.web.controller.CustomerController;
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
@WebMvcTest(value = CustomerController.class, secure = false)
@ContextConfiguration(classes = TestApplication.class)
@AutoConfigureMockMvc
public class CustomerControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerApplicationService customerApplicationService;

    String exampleDTOJson = "{\"id\":\"customerId\",\"pw\":\"password\",\"name\":\"name\",\"address\":\"address\",\"registeredDay\":\"today\"}";

    @Test
    public void retrieveCustomer() throws Exception {
        CustomerInfo mockCustomerInfo = new CustomerInfo("customer01", "password", "name01", "address01", "Monday");

        Mockito.when(
                customerApplicationService.getCustomerByID(Mockito.anyString())
        ).thenReturn(mockCustomerInfo);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customers/{id}", mockCustomerInfo.getID()).accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{id:customer01,name:name01,address:address01,registeredDay:Monday}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void registerCustomer() throws Exception {
        CustomerInfo mockCustomerInfo = new CustomerInfo("customer02", "password", "name02", "address02", "Tuesday");

        Mockito.when(
                customerApplicationService.registerCustomer(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())
        ).thenReturn(mockCustomerInfo);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/customers")
                .accept(MediaType.APPLICATION_JSON)
                .content(exampleDTOJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{id:customer02,name:name02,address:address02,registeredDay:Tuesday}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void withdrawCustomer() throws Exception {
//        CustomerInfo mockCustomerInfo = new CustomerInfo("customer03", "password", "name03", "address03", "Wednesday");
//
//        mockCustomerInfo.removeCustomerInfo("customer03", "password");
//
//        Mockito.when(
//                customerApplicationService.withdrawCustomer(Mockito.anyString(), Mockito.anyString())
//        ).thenReturn(mockCustomerInfo);
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .delete("/customers/{id}", mockCustomerInfo.getID())
//                .accept(MediaType.APPLICATION_JSON)
//                .content(exampleDTOJson)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        String expected = "{id:,name:,address:,registeredDay:}";
//
//        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void updateCustomer() throws Exception {
        CustomerInfo mockCustomerInfo = new CustomerInfo("customer04", "password", "name04", "address04", "Thursday");

        Mockito.when(
                customerApplicationService.updateCustomer(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())
        ).thenReturn(mockCustomerInfo);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/customers/{id}", mockCustomerInfo.getID())
                .accept(MediaType.APPLICATION_JSON)
                .content(exampleDTOJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{id:customer04,name:name04,address:address04,registeredDay:Thursday}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void getCustomerPoint() throws Exception {
    }
}
