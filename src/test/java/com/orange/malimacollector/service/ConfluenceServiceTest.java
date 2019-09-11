package com.orange.malimacollector.service;

import com.orange.malimacollector.config.MachineConfiguration;
import com.orange.malimacollector.service.confluence.ConfluenceService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class ConfluenceServiceTest {
    @Autowired
    private MachineConfiguration config;

    @Autowired
    ConfluenceService service;

    @Test
    void buildURL() {
        assertEquals(this.config.getWebsites()[0].getLocalAddress() + "/search?cql=(type=page and space=ds)", service.buildURL());
    }

    @Test
    void getData() {
        assertNotNull(service.getData(service.buildURL()));
    }

    @Test
    void handler() {
        assertNotNull(service.handler());
    }
}