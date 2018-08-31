package com.itchain.samplemsa.samplemsa.customer;

import com.itchain.samplemsa.samplemsa.TestApplication;
import com.itchain.samplemsa.samplemsa.customer.application.CustomerApplicationService;
import com.itchain.samplemsa.samplemsa.customer.domain.CustomerIDService;
import com.itchain.samplemsa.samplemsa.customer.domain.CustomerInfo;
import com.itchain.samplemsa.samplemsa.customer.domain.CustomerPriceService;
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
public class CustomerApplicationServiceTest {
    @Autowired
    private CustomerApplicationService customerApplicationService;

    @Autowired
    private CustomerPriceService customerPriceService;

    @Autowired
    private CustomerIDService customerIDService;

    @Test
    public void customerApplicationService() throws Exception {
        // given
        String customerID = "customerId";
        String customerPassword = "password";
        String customerName = "JohnDoe";
        String customerAddress = "MyHome";

        // REGISTER TEST

        // when : success
        Mockito.when(customerIDService.checkDuplicatedID(customerID)).thenReturn(false);

        CustomerInfo c = customerApplicationService.registerCustomer(customerID, customerPassword, customerName, customerAddress);

        // then
        Assert.assertEquals("customerId", c.getID());

        // when : id is null

        // when : password is too short


        // GET TEST

        // when : success

        // when : no ID


        // WITHDRAW TEST

        // when


        // UPDATE TEST

        // when : success

        // when : password is too short


        // GET POINT TEST

        // when
    }
}
