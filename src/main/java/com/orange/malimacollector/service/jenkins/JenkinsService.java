package com.orange.malimacollector.service.jenkins;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
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

    public String buildURL(){
        String newURL = this.config.getWebsites()[2].getLocalAddress();
        newURL += "api/json?pretty=true";
        return newURL;
    }

    public String getData(String url){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(this.config.getWebsites()[2].getAdminUsername(),
                this.config.getWebsites()[2].getAdminPassword()));
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        return response.getBody();
    }

    public static JenkinsInfo fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    private static ObjectReader reader;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        reader = mapper.reader(JenkinsInfo.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    public Object handler(){
        String url;
        String content;
        url = buildURL();
        content = getData(url);
        try {
            return fromJsonString(content);
        } catch (IOException e) {
            logger.error("Jenkins Service:" + e.getMessage());
            return null;
        }
    }
}
