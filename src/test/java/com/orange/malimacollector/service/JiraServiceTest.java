package com.orange.malimacollector.service;

import com.orange.malimacollector.config.MachineConfiguration;
import com.orange.malimacollector.entities.jira.Project;
import com.orange.malimacollector.service.jira.JiraService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class JiraServiceTest {
    @Autowired
    private MachineConfiguration config;

    @Autowired
    JiraService service;

    @Test
    void buildURL() {
        assertEquals(this.config.getWebsites()[3].getLocalAddress() + "search", service.buildURL(1));
        assertEquals(this.config.getWebsites()[3].getLocalAddress() + "project", service.buildURL(2));
    }

    @Test
    void getData() throws IOException {
        assertNotNull(service.getData(service.buildURL(2)));
    }

    @Test
    void testGetData() throws IOException {
        Project[] projects = service.projectFromJsonString(service.getData(service.buildURL(2)));
        for (Project project : projects) {
            assertNotNull(service.getData(project.getName(), service.buildURL(1)));
        }
    }

    @Test
    void handler() {
        assertNotNull(service.handler(1));
        assertNotNull(service.handler(2));
    }
}