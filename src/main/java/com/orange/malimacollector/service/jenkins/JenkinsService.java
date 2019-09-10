package com.orange.malimacollector.service.jenkins;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.orange.malimacollector.config.MachineConfiguration;
import com.orange.malimacollector.entities.jenkins.JenkinsInfo;
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
public class JenkinsService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MachineConfiguration config;

    public String buildURL(int choice){
        String newURL = this.config.getWebsites()[2].getLocalAddress();
        switch (choice){
            case 1:
                newURL += "api/json?pretty=true";
                break;
            case 2:
                newURL += "";
                break;
        }
        return newURL;
    }

    public String getData(String URL){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(this.config.getWebsites()[2].getAdminUsername(),
                this.config.getWebsites()[2].getAdminPassword()));
        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, null, String.class);
        return response.getBody();
    }

    public static JenkinsInfo fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(JenkinsInfo obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        reader = mapper.reader(JenkinsInfo.class);
        writer = mapper.writerFor(JenkinsInfo.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }

    public Object handler(int choice){
        String URL;
        String content;
        URL = buildURL(1);
        content = getData(URL);
        try {
            return fromJsonString(content);
        } catch (IOException e) {
            logger.error("Jenkins Service:" + e.getMessage());
            return null;
        }
    }
}
