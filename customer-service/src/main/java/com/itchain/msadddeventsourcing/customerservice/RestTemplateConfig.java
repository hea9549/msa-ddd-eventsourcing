package com.itchain.msadddeventsourcing.customerservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriTemplateHandler;

@Configuration
public class RestTemplateConfig {

    @Bean("orderRestTemplate")
    public RestTemplate ProductRestTemplate() {
        DefaultUriTemplateHandler defaultUriTemplateHandler = new DefaultUriTemplateHandler();
        defaultUriTemplateHandler.setBaseUrl("http://localhost:8083");
        RestTemplate orderRestTemplate = new RestTemplate();
        orderRestTemplate.setUriTemplateHandler(defaultUriTemplateHandler);

        return orderRestTemplate;
    }

    @Bean("deliveryRestTemplate")
    public RestTemplate DeliverRestTemplate() {
        DefaultUriTemplateHandler defaultUriTemplateHandler = new DefaultUriTemplateHandler();
        defaultUriTemplateHandler.setBaseUrl("http://localhost:8082");
        RestTemplate deliveryRestTemplate = new RestTemplate();
        deliveryRestTemplate.setUriTemplateHandler(defaultUriTemplateHandler);

        return deliveryRestTemplate;
    }
}