package com.orange.malimacollector.service;

import com.orange.malimacollector.config.MachineConfiguration;
import com.orange.malimacollector.service.gitlab.GitlabService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class GitlabServiceTest {
    @Autowired
    private MachineConfiguration config;

    @Autowired
    GitlabService service;

    @Test
    void buildURL() {
        assertEquals(this.config.getWebsites()[1].getLocalAddress() + "users/" + this.config.getWebsites()[1].getAdminUsername() + "/projects?private_token=" +
                        this.config.getWebsites()[1].getAdminPassword(), service.buildURL(this.config.getWebsites()[1].getAdminPassword(), this.config.getWebsites()[1].getAdminUsername()));
    }

    @Test
    void getData() {
        assertNotNull(service.getData(service.buildURL(this.config.getWebsites()[1].getAdminPassword(), this.config.getWebsites()[1].getAdminUsername())));
    }

    @Test
    void handler() {
        assertNotNull(service.handler());
    }
}