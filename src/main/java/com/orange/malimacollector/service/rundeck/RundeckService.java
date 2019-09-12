package com.orange.malimacollector.service.rundeck;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.orange.malimacollector.config.MachineConfiguration;
import com.orange.malimacollector.entities.rundeck.Job;
import com.orange.malimacollector.entities.rundeck.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class RundeckService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MachineConfiguration config;

    public String buildURL(int choice){
        String newURL = this.config.getWebsites()[5].getLocalAddress();
        if (choice == 1) {
            newURL += "api/1/projects";
        } else {
            newURL += "api/14/project/";
        }
        return newURL;
    }

    public String getData(String url){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }

    public static Project[] projectFromJsonString(String json) throws IOException {
        return getProjectReader().readValue(json);
    }

    public static Job[] jobFromJsonString(String json) throws IOException {
        return getJobReader().readValue(json);
    }

    private static ObjectReader projectReader;

    private static ObjectReader jobReader;

    private static void instantiateProjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        projectReader = mapper.reader(Project[].class);
    }

    private static void instantiateJobMapper() {
        ObjectMapper mapper = new ObjectMapper();
        jobReader = mapper.reader(Job[].class);
    }

    private static ObjectReader getProjectReader() {
        if (projectReader == null) instantiateProjectMapper();
        return projectReader;
    }

    private static ObjectReader getJobReader() {
        if (jobReader == null) instantiateJobMapper();
        return jobReader;
    }

    public Object handler(int choice){
        String url;
        String content;
        if (choice == 1) {
            url = buildURL(1);
            url += ("?authtoken=" + this.config.getWebsites()[5].getAdminPassword());
            content = getData(url);
            try {
                return projectFromJsonString(content);
            } catch (IOException e) {
                logger.error("Rundeck Project Error:" + e.getMessage());
                return null;
            }
        } else {
            url = buildURL(2);
            Project[] projects = (Project[]) handler(1);
            ArrayList<Job[]> jobCollection = new ArrayList<>();
            for (Project project : projects) {
                String newURL = url + project.getName() + "/jobs?authtoken=" + this.config.getWebsites()[5].getAdminPassword();
                content = getData(newURL);
                try {
                    jobCollection.add(jobFromJsonString(content));
                } catch (IOException e) {
                    logger.error("Rundeck Job Error:" + e.getMessage());
                }
            }
            return jobCollection;
        }
    }
}
