package com.orange.malimacollector.service.gitlab;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.orange.malimacollector.config.MachineConfiguration;
import com.orange.malimacollector.entities.gitlab.GitLabParameters;
import com.orange.malimacollector.entities.gitlab.Group;
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

    private GitLabParameters parameters = new GitLabParameters(true, false, false, true);

    public GitLabParameters getParameters() {
        return parameters;
    }

    public void setParameters(GitLabParameters parameters) {
        this.parameters = parameters;
    }

    public String buildURL(String privateToken, String ID){
        String newURL = this.config.getWebsites()[1].getLocalAddress();
        String modifier;
        if (parameters.isGroup()){
            modifier = "groups/";
        } else if (parameters.isProjects()){
            modifier = "users/";
        } else {
            modifier = "";
        }
        newURL += modifier;
        if (parameters.hasID()) {
            newURL = newURL + ID + "/";
        }
        newURL += ("projects" + "?private_token=" + privateToken);
        return newURL;
    }

    public String getData(String URL){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, null, String.class);
        return response.getBody();
    }
    // Serialize/deserialize helpers

    public static Project[] projectFromJsonString(String json) throws IOException {
        return getProjectObjectReader().readValue(json);
    }

    public static String projectToJsonString(Project[] obj) throws JsonProcessingException {
        return getProjectObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateProjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        reader = mapper.reader(Project[].class);
        writer = mapper.writerFor(Project[].class);
    }

    private static ObjectReader getProjectObjectReader() {
        if (reader == null) instantiateProjectMapper();
        return reader;
    }

    private static ObjectWriter getProjectObjectWriter() {
        if (writer == null) instantiateProjectMapper();
        return writer;
    }

    public static Group groupFromJsonString(String json) throws IOException {
        return getGroupObjectReader().readValue(json);
    }

    public static String groupToJsonString(Group obj) throws JsonProcessingException {
        return getGroupObjectWriter().writeValueAsString(obj);
    }

    private static void instantiateGroupMapper() {
        ObjectMapper mapper = new ObjectMapper();
        reader = mapper.reader(Group.class);
        writer = mapper.writerFor(Group.class);
    }

    private static ObjectReader getGroupObjectReader() {
        if (reader == null) instantiateGroupMapper();
        return reader;
    }

    private static ObjectWriter getGroupObjectWriter() {
        if (writer == null) instantiateGroupMapper();
        return writer;
    }

    public Project[] handler(){
        String URL = buildURL(this.config.getWebsites()[1].getAdminPassword(),
                this.config.getWebsites()[1].getAdminUsername());
        String content = getData(URL);
            try {
                return projectFromJsonString(content);
            } catch (IOException e) {
                logger.error("Gitlab Service: " + e.getMessage());
                return null;
            }
    }
}
