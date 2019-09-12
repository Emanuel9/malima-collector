package com.orange.malimacollector.service.jira;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.orange.malimacollector.config.MachineConfiguration;
import com.orange.malimacollector.entities.jira.Issue;
import com.orange.malimacollector.entities.jira.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class JiraService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MachineConfiguration config;

    public String buildURL(int choice) {
        String newURL = this.config.getWebsites()[3].getLocalAddress();
        if (choice == 1){
            newURL += "search";
        } else {
            newURL += "project";
        }
        return newURL;
    }

    public String getData(String projectName, String url){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(this.config.getWebsites()[3].getAdminUsername(),
                this.config.getWebsites()[3].getAdminPassword()));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String requestJSON = "{\"jql\":\"project =" + projectName + "\",\"startAt\":0,\"fields\":[\"id\",\"key\",\"name\",\"description\"]}";
        HttpEntity<String> requestEntity = new HttpEntity<>(requestJSON, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        return response.getBody();
    }

    public String getData(String url){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(this.config.getWebsites()[3].getAdminUsername(),
                this.config.getWebsites()[3].getAdminPassword()));
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        return response.getBody();
    }

    public static Project[] projectFromJsonString(String json) throws IOException {
        return getProjectReader().readValue(json);
    }

    public static Issue issueFromJsonString(String json) throws IOException {
        return getIssueReader().readValue(json);
    }

    private static ObjectReader projectReader;

    private static ObjectReader issueReader;

    private static void instantiateProjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        projectReader = mapper.reader(Project[].class);
    }

    private static void instantiateIssueMapper() {
        ObjectMapper mapper = new ObjectMapper();
        issueReader = mapper.reader(Issue.class);
    }

    private static ObjectReader getProjectReader() {
        if (projectReader == null) instantiateProjectMapper();
        return projectReader;
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
            try {
                Project[] projects = projectFromJsonString(getData(buildURL(2)));
                ArrayList<Issue> issues = new ArrayList<>();
                for (Project project : projects) {
                    content = getData(project.getName(), url);
                    Issue issue = issueFromJsonString(content);
                    issues.add(issue);
                }
                return issues;
            } catch (IOException e) {
                logger.error("Jira Issues Error:" + e.getMessage());
                return null;
            }
        } else if (choice == 2) {
            url = buildURL(2);
            content = getData(url);
            try {
                return projectFromJsonString(content);
            } catch (IOException e) {
                logger.error("Jira Project Error" + e.getMessage());
                return null;
            }
        } else {
            return null;
        }
    }
}
