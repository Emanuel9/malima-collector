package com.orange.malimacollector.config;

import com.orange.malimacollector.entities.Website;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "address")
public class MachineConfiguration {
    private Website[] websites;

    public Website[] getWebsites() {
        return websites;
    }

    public void setWebsites(Website[] websites) {
        this.websites = websites;
    }
}
