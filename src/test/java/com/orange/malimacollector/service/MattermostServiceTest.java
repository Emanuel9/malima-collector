package com.orange.malimacollector.service;

import com.orange.malimacollector.config.MachineConfiguration;
import com.orange.malimacollector.entities.mattermost.Channel;
import com.orange.malimacollector.entities.mattermost.Teams;
import com.orange.malimacollector.service.mattermost.MattermostService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class MattermostServiceTest {
    @Autowired
    private MachineConfiguration config;

    @Autowired
    MattermostService service;

    @Test
    void buildURL() {
        assertEquals(this.config.getWebsites()[4].getLocalAddress() + "users/me", service.buildURL(1));
        assertEquals(this.config.getWebsites()[4].getLocalAddress() + "teams", service.buildURL(2));
        assertEquals(this.config.getWebsites()[4].getLocalAddress() + "teams/", service.buildURL(3));
        assertEquals(this.config.getWebsites()[4].getLocalAddress() + "channels/", service.buildURL(4));
    }

    @Test
    void getData() {
        assertNotNull(service.getData(service.buildURL(1)));
    }

    @Test
    void testGetData() {
        assertNotNull(service.getData(service.buildURL(3), ((Teams[])service.handler(2))[0], "test"));
    }

    @Test
    void handler() {
        assertNotNull(service.handler(1));
        assertNotNull(service.handler(2));
    }

    @Test
    void testHandler() {
        assertNotNull(service.handler(((Teams[])service.handler(2))[0]));
    }

    @Test
    void testHandler1() {
        assertNotNull(service.handler(((Channel[])service.handler(((Teams[])service.handler(2))[0]))[0]));
    }

    @Test
    void testHandler2() {
        assertNotNull("test",service.handler(((Teams[])service.handler(2))[0]));
    }
}