package com.itchain.samplemsa.samplemsa.Trade;


import com.itchain.samplemsa.samplemsa.customer.domain.CustomerService;
import com.itchain.samplemsa.samplemsa.mock.mockCustomerService;
import com.itchain.samplemsa.samplemsa.mock.mockDeliveryService;
import com.itchain.samplemsa.samplemsa.mock.mockProductService;
import com.itchain.samplemsa.samplemsa.trade.domain.DeliveryService;
import com.itchain.samplemsa.samplemsa.trade.domain.ProductService;
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
    public CustomerService customerService() { return Mockito.mock(mockCustomerService.class);}

}
