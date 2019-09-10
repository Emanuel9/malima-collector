package com.orange.malimacollector.service.confluence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.orange.malimacollector.config.MachineConfiguration;
import com.orange.malimacollector.entities.confluence.Page;
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
public class ConfluenceService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MachineConfiguration config;

    public String buildURL(int choice){
        String newURL = this.config.getWebsites()[0].getLocalAddress();
        switch(choice){
            case 1:
                newURL += "/search?cql=(type=page and space=ds)";
                break;
            case 2:
                newURL += "";
                break;
        }
        return newURL;
    }

    public String getData(String URL){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(this.config.getWebsites()[0].getAdminUsername(),
                this.config.getWebsites()[0].getAdminPassword()));
        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, null, String.class);
        return response.getBody();
    }

    public static Page pageFromJsonString(String json) throws IOException {
        return getPageReader().readValue(json);
    }

    public static String pageToJsonString(Page obj) throws JsonProcessingException {
        return getPageWriter().writeValueAsString(obj);
    }

    private static ObjectReader pageReader;
    private static ObjectWriter pageWriter;

    private static void instantiatePageMapper() {
        ObjectMapper mapper = new ObjectMapper();
        pageReader = mapper.reader(Page.class);
        pageWriter = mapper.writerFor(Page.class);
    }

    private static ObjectReader getPageReader() {
        if (pageReader == null) instantiatePageMapper();
        return pageReader;
    }

    private static ObjectWriter getPageWriter() {
        if (pageWriter == null) instantiatePageMapper();
        return pageWriter;
    }

    public Object handler(int choice){
        String URL;
        String content;
        URL = buildURL(1);
        content = getData(URL);
        try {
            return pageFromJsonString(content);
        } catch (IOException e) {
            LOGGER.error("Confluence Service: " + e.getMessage());
        }
        return null;
    }
}
