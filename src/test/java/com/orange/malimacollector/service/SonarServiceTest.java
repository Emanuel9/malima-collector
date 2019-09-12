package com.orange.malimacollector.service;

import com.orange.malimacollector.config.MachineConfiguration;
import com.orange.malimacollector.service.sonar.SonarService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class SonarServiceTest {
    @Autowired
    private MachineConfiguration config;

    @Autowired
    SonarService service;

    @Test
    void buildURL() {
        assertEquals(this.config.getWebsites()[6].getLocalAddress() + "issues/search", service.buildURL(1));
        assertEquals(this.config.getWebsites()[6].getLocalAddress() + "projects/search", service.buildURL(2));
    }

    @Test
    void getData() {
        assertNotNull(service.getData(service.buildURL(1)));
    }

    @Test
    void handler() {
        assertNotNull(service.handler(1));
        assertNotNull(service.handler(2));
    }
}