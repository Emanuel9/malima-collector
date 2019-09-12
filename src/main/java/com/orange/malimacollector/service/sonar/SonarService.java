package com.orange.malimacollector.service.sonar;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.orange.malimacollector.config.MachineConfiguration;
import com.orange.malimacollector.entities.sonar.Issue;
import com.orange.malimacollector.entities.sonar.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class SonarService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MachineConfiguration config;

    public String buildURL(int choice){
        String newURL = this.config.getWebsites()[6].getLocalAddress();
        if (choice == 1) {
            newURL += "issues/search";
        } else {
            newURL += "projects/search";
        }
        return newURL;
    }

    public String getData(String url){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(this.config.getWebsites()[6].getAdminUsername(),
                this.config.getWebsites()[6].getAdminPassword()));
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        return response.getBody();
    }

    public static Project projectFromJsonString(String json) throws IOException {
        return getProjectReader().readValue(json);
    }

    public static Issue issueFromJsonString(String json) throws IOException {
        return getIssueReader().readValue(json);
    }

    private static ObjectReader projectReader;

    private static ObjectReader issueReader;

    private static void instantiateProjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        projectReader = mapper.reader(Project.class);
    }

    private static ObjectReader getProjectReader() {
        if (projectReader == null) instantiateProjectMapper();
        return projectReader;
    }

    private static void instantiateIssueMapper() {
        ObjectMapper mapper = new ObjectMapper();
        issueReader = mapper.reader(Issue.class);
    }

    private static ObjectReader getIssueReader() {
        if (issueReader == null) instantiateIssueMapper();
        return issueReader;
    }

    public Object handler(int choice){
        String url;
        String content;
        if (choice == 1) {
            url = buildURL(1);
            content = getData(url);
            try {
                return issueFromJsonString(content);
            } catch (IOException e) {
                logger.error("Sonar Issues Error:" + e.getMessage());
                return null;
            }
        } else {
            url = buildURL(2);
            content = getData(url);
            try {
                return projectFromJsonString(content);
            } catch (IOException e) {
                logger.error("Sonar Project Error:" + e.getMessage());
                return null;
            }
        }
    }
}
