package com.orange.malimacollector.config;

import com.orange.malimacollector.entities.Website;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:configuration.properties")
@ConfigurationProperties(prefix = "address")
public class MachineConfiguration {
    private Website[] websites;
}
