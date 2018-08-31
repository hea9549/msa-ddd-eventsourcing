package com.itchain.samplemsa.samplemsa.Order;


import com.itchain.samplemsa.samplemsa.customer.domain.CustomerIDService;
import com.itchain.samplemsa.samplemsa.mock.MockCustomerIDService;
import com.itchain.samplemsa.samplemsa.mock.mockDeliveryService;
import com.itchain.samplemsa.samplemsa.mock.mockProductService;
import com.itchain.samplemsa.samplemsa.order.domain.DeliveryService;
import com.itchain.samplemsa.samplemsa.order.domain.ProductService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class ServiceConfiguration {

    @Bean
    @Primary
    public ProductService productService() {
        return Mockito.mock(mockProductService.class);
    }

    @Bean
    @Primary
    public DeliveryService deliveryService() {
        return Mockito.mock(mockDeliveryService.class);
    }

    @Bean
    @Primary
    public CustomerIDService customerService() { return Mockito.mock(MockCustomerIDService.class);}

}
