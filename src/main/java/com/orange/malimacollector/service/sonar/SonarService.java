package com.orange.malimacollector.service.sonar;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.orange.malimacollector.config.MachineConfiguration;
import com.orange.malimacollector.entities.sonar.Issue;
import com.orange.malimacollector.entities.sonar.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class SonarService {
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

    public static String projectToJsonString(Project obj) throws JsonProcessingException {
        return getProjectWriter().writeValueAsString(obj);
    }

    public static Issue issueFromJsonString(String json) throws IOException {
        return getIssueReader().readValue(json);
    }

    public static String issueToJsonString(Project obj) throws JsonProcessingException {
        return getIssueWriter().writeValueAsString(obj);
    }

    private static ObjectReader projectReader;
    private static ObjectWriter projectWriter;

    private static ObjectReader issueReader;
    private static ObjectWriter issueWriter;

    private static void instantiateProjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        projectReader = mapper.reader(Project.class);
        projectWriter = mapper.writerFor(Project.class);
    }

    private static ObjectReader getProjectReader() {
        if (projectReader == null) instantiateProjectMapper();
        return projectReader;
    }

    private static ObjectWriter getProjectWriter() {
        if (projectWriter == null) instantiateProjectMapper();
        return projectWriter;
    }

    private static void instantiateIssueMapper() {
        ObjectMapper mapper = new ObjectMapper();
        issueReader = mapper.reader(Issue.class);
        issueWriter = mapper.writerFor(Issue.class);
    }

    private static ObjectReader getIssueReader() {
        if (issueReader == null) instantiateIssueMapper();
        return issueReader;
    }

    private static ObjectWriter getIssueWriter() {
        if (issueWriter == null) instantiateIssueMapper();
        return issueWriter;
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
                e.printStackTrace();
                return null;
            }
        } else {
            url = buildURL(2);
            content = getData(url);
            try {
                return projectFromJsonString(content);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
