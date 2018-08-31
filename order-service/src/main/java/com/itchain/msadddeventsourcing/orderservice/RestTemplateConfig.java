package com.itchain.msadddeventsourcing.orderservice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriTemplateHandler;

@Configuration
public class RestTemplateConfig {

    @Bean("productRestTemplate")
    public RestTemplate ProductRestTemplate() {
        DefaultUriTemplateHandler defaultUriTemplateHandler = new DefaultUriTemplateHandler();
        defaultUriTemplateHandler.setBaseUrl("http://localhost:8080");
        RestTemplate productRestTemplate = new RestTemplate();
        productRestTemplate.setUriTemplateHandler(defaultUriTemplateHandler);

        return productRestTemplate;
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
