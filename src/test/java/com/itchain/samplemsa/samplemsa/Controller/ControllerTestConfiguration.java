package com.itchain.samplemsa.samplemsa.Controller;

import com.itchain.samplemsa.samplemsa.trade.application.TradeApplicationService;
import com.itchain.samplemsa.samplemsa.trade.application.TradeApplicationServiceImpl;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("controllerTest")
@Configuration
public class ControllerTestConfiguration {
    @Bean
    @Primary
    public TradeApplicationService tradeApplicationService() { return Mockito.mock(TradeApplicationServiceImpl.class);
    }
}
