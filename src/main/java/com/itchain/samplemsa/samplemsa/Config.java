package com.itchain.samplemsa.samplemsa;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "env")
public class Config {
    private String HOST;
    private String PORT;
    private String PROTOCOL;
    private List<String> SERVICE = new ArrayList<String>();
}
