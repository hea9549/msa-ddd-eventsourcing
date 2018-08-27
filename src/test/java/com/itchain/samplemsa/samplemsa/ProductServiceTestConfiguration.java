package com.itchain.samplemsa.samplemsa;


import com.itchain.samplemsa.samplemsa.trade.application.TradeApplicationService;
import com.itchain.samplemsa.samplemsa.trade.application.TradeApplicationServiceImpl;
import com.itchain.samplemsa.samplemsa.trade.domain.DeliveryService;
import com.itchain.samplemsa.samplemsa.trade.domain.ProductService;
import com.itchain.samplemsa.samplemsa.trade.port.adapter.service.ProductServiceImpl;
import com.itchain.samplemsa.samplemsa.trade.web.controller.TradeController;
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

//    @Bean
//    @Primary
//    public TradeApplicationServiceImpl tradeApplicationService()  { return Mockito.mock(TradeApplicationServiceImpl.class); }
//
//    @Bean
//    @Primary
//    public TradeController tradeController() { return Mockito.mock(TradeController.class);}

}
