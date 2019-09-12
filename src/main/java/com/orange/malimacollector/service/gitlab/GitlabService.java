package com.orange.malimacollector.service.gitlab;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.orange.malimacollector.config.MachineConfiguration;
import com.orange.malimacollector.entities.gitlab.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class GitlabService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MachineConfiguration config;

    public String buildURL(String privateToken, String id){
        String newURL = this.config.getWebsites()[1].getLocalAddress();
        String modifier = "users/";
        newURL += modifier;
        newURL = newURL + id + "/";
        newURL += ("projects" + "?private_token=" + privateToken);
        return newURL;
    }

    public String getData(String url){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        return response.getBody();
    }
    // Serialize/deserialize helpers

    public static Project[] projectFromJsonString(String json) throws IOException {
        return getProjectObjectReader().readValue(json);
    }

    private static ObjectReader reader;

    private static void instantiateProjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        reader = mapper.reader(Project[].class);
    }

    private static ObjectReader getProjectObjectReader() {
        if (reader == null) instantiateProjectMapper();
        return reader;
    }

    public Project[] handler(){
        String url = buildURL(this.config.getWebsites()[1].getAdminPassword(),
                this.config.getWebsites()[1].getAdminUsername());
        String content = getData(url);
            try {
                return projectFromJsonString(content);
            } catch (IOException e) {
                logger.error("Gitlab Service: " + e.getMessage());
                return new Project[]{};
            }
    }
}
