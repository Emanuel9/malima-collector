package com.orange.malimacollector.service.Gitlab;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.orange.malimacollector.config.MachineConfiguration;
import com.orange.malimacollector.entities.GitlabEntities.GitLabParameters;
import com.orange.malimacollector.entities.GitlabEntities.Group;
import com.orange.malimacollector.entities.GitlabEntities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orange.malimacollector.service.URLService;

import java.io.IOException;

@Service
public class GitlabService {
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
        String URL = buildURL(this.config.getWebsites()[1].getAdminPassword(),this.config.getWebsites()[1].getAdminUsername());
        String content = new URLService().callURL(URL);
            try {
                return projectFromJsonString(content);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
    }
}
