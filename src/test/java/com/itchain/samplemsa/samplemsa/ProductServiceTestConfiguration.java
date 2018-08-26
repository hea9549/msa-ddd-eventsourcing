package com.itchain.samplemsa.samplemsa;


import com.itchain.samplemsa.samplemsa.trade.domain.DeliveryService;
import com.itchain.samplemsa.samplemsa.trade.domain.ProductService;
import com.itchain.samplemsa.samplemsa.trade.port.adapter.service.ProductServiceImpl;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class ProductServiceTestConfiguration {

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

}
