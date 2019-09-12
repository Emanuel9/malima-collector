package com.orange.malimacollector.service.confluence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
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
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MachineConfiguration config;

    public String buildURL(){
        String newURL = this.config.getWebsites()[0].getLocalAddress();
        newURL += "/search?cql=(type=page and space=ds)";
        return newURL;
    }

    public String getData(String url){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(this.config.getWebsites()[0].getAdminUsername(),
                this.config.getWebsites()[0].getAdminPassword()));
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        return response.getBody();
    }

    public static Page pageFromJsonString(String json) throws IOException {
        return getPageReader().readValue(json);
    }

    private static ObjectReader pageReader;

    private static void instantiatePageMapper() {
        ObjectMapper mapper = new ObjectMapper();
        pageReader = mapper.reader(Page.class);
    }

    private static ObjectReader getPageReader() {
        if (pageReader == null) instantiatePageMapper();
        return pageReader;
    }

    public Object handler(){
        String url;
        String content;
        url = buildURL();
        content = getData(url);
        try {
            return pageFromJsonString(content);
        } catch (IOException e) {
            logger.error("Confluence Service: " + e.getMessage());
        }
        return null;
    }
}
