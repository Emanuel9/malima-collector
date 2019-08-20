package com.orange.malimacollector.service.Sonar;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.orange.malimacollector.config.MachineConfiguration;
import com.orange.malimacollector.entities.SonarEntities.Issue;
import com.orange.malimacollector.entities.SonarEntities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Paths;

@Service
public class SonarService {
    @Autowired
    private MachineConfiguration config;

    public String buildURL(int choice){
        String newURL = this.config.getWebsites()[6].getLocalAddress();
        switch (choice){
            case 1:
                newURL += "issues/search";
                break;
            case 2:
                newURL += "projects/search";
                break;
        }
        return newURL;
    }

    public String curlCommand(String URL) {
        String command = "curl -u " + this.config.getWebsites()[6].getAdminUsername() + ":" +
                this.config.getWebsites()[6].getAdminPassword() + " " + URL;
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        processBuilder.directory(Paths.get("C:/Windows/System32").toFile());
        try {
            Process process = processBuilder.start();
            StringBuilder sb = new StringBuilder();
            InputStreamReader in = null;
            in = new InputStreamReader(process.getInputStream(), Charset.defaultCharset());
            BufferedReader bufferedReader = new BufferedReader(in);
            if (bufferedReader != null) {
                int cp;
                while ((cp = bufferedReader.read()) != -1) {
                    sb.append((char) cp);
                }
                bufferedReader.close();
            }
            in.close();
            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Project projectFromJsonString(String json) throws IOException {
        return getProjectReader().readValue(json);
    }

    public static String projectToJsonString(Project obj) throws JsonProcessingException {
        return getProjectWriter().writeValueAsString(obj);
    }

    public static Issue issueFromJsonString(String json) throws IOException {
        return getIssueReader().readValue(json);
    }

    public static String issueToJsonString(Project obj) throws JsonProcessingException {
        return getIssueWriter().writeValueAsString(obj);
    }

    private static ObjectReader projectReader;
    private static ObjectWriter projectWriter;

    private static ObjectReader issueReader;
    private static ObjectWriter issueWriter;

    private static void instantiateProjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        projectReader = mapper.reader(Project.class);
        projectWriter = mapper.writerFor(Project.class);
    }

    private static ObjectReader getProjectReader() {
        if (projectReader == null) instantiateProjectMapper();
        return projectReader;
    }

    private static ObjectWriter getProjectWriter() {
        if (projectWriter == null) instantiateProjectMapper();
        return projectWriter;
    }

    private static void instantiateIssueMapper() {
        ObjectMapper mapper = new ObjectMapper();
        issueReader = mapper.reader(Issue.class);
        issueWriter = mapper.writerFor(Issue.class);
    }

    private static ObjectReader getIssueReader() {
        if (issueReader == null) instantiateIssueMapper();
        return issueReader;
    }

    private static ObjectWriter getIssueWriter() {
        if (issueWriter == null) instantiateIssueMapper();
        return issueWriter;
    }

    public Object handler(int choice){
        String URL;
        String content;
        switch (choice){
            case 1:
                URL = buildURL(1);
                content = curlCommand(URL);
                try {
                    return issueFromJsonString(content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            case 2:
                URL = buildURL(2);
                content = curlCommand(URL);
                try {
                    return projectFromJsonString(content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            default:
                return null;
        }
    }
}
