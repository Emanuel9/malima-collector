package com.orange.malimacollector.service.Gitlab;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.orange.malimacollector.entities.GitLabParameters;
import com.orange.malimacollector.entities.Group;
import com.orange.malimacollector.entities.Project;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

@Service
public class GitlabService {
    private GitLabParameters parameters = new GitLabParameters(true, false, false, true);

    public GitLabParameters getParameters() {
        return parameters;
    }

    public void setParameters(GitLabParameters parameters) {
        this.parameters = parameters;
    }

    public String buildURL(String privateToken, String ID){
        String newURL = "https://gitlab.com/api/v4/";
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

    public String callURL(String myURL) {
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;
        try {
            URL url = new URL(myURL);
            urlConn = url.openConnection();
            if (urlConn != null)
                urlConn.setReadTimeout(60 * 1000);
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(),
                        Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);
                if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                }
            }
            in.close();
        } catch (Exception e) {
            throw new RuntimeException("Exception while calling URL:"+ myURL, e);
        }

        return sb.toString();
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
        String URL = buildURL("8aHcnAb8eVSjauuSkQj7","4278148");
        String content = callURL(URL);
            try {
                return projectFromJsonString(content);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
    }
}
