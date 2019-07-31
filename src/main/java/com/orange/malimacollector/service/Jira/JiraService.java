package com.orange.malimacollector.service.Jira;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.orange.malimacollector.entities.JiraEntities.Issue;
import com.orange.malimacollector.entities.JiraEntities.Project;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;

@Service
public class JiraService {
    public String buildURL(int choice){
        String newURL = "http://localhost:8090/rest/api/2/";
        switch (choice){
            case 1:
                newURL += "search";
                break;
            case 2:
                newURL += "project";
        }
        return newURL;
    }

    public String curlCommands(String projectName, String URL){
        StringBuilder stringBuilder = new StringBuilder();
            stringBuilder
                    .append("curl -u alexm:admin -X POST ")
                    .append("-H \"Content-Type: application/json\" ")
                    .append("--data \"{\\\"jql\\\":\\\"project =")
                    .append(projectName)
                    .append("\\\",\\\"startAt\\\":0,\\\"fields\\\":[\\\"id\\\",\\\"key\\\",\\\"name\\\",\\\"description\\\"]}\" ")
                    .append(URL);
        String command = stringBuilder.toString();
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

        } catch (
        IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String curlCommands(String URL){
        String command = "curl -u alexm:admin " + URL;
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

    public static Project[] projectFromJsonString(String json) throws IOException {
        return getProjectReader().readValue(json);
    }

    public static String projectToJsonString(Project[] obj) throws JsonProcessingException {
        return getProjectWriter().writeValueAsString(obj);
    }

    public static Issue issueFromJsonString(String json) throws IOException {
        return getIssueReader().readValue(json);
    }

    public static String issueToJsonString(Issue obj) throws JsonProcessingException {
        return getIssueWriter().writeValueAsString(obj);
    }

    private static ObjectReader projectReader;
    private static ObjectWriter projectWriter;

    private static ObjectReader issueReader;
    private static ObjectWriter issueWriter;

    private static void instantiateProjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        projectReader = mapper.reader(Project[].class);
        projectWriter = mapper.writerFor(Project[].class);
    }

    private static void instantiateIssueMapper() {
        ObjectMapper mapper = new ObjectMapper();
        issueReader = mapper.reader(Issue.class);
        issueWriter = mapper.writerFor(Issue.class);
    }

    private static ObjectReader getProjectReader() {
        if (projectReader == null) instantiateProjectMapper();
        return projectReader;
    }

    private static ObjectWriter getProjectWriter() {
        if (projectWriter == null) instantiateProjectMapper();
        return projectWriter;
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
                try {
                    Project[] projects = projectFromJsonString(curlCommands(buildURL(2)));
                    ArrayList<Issue> issues= new ArrayList<>();
                    for (Project project: projects) {
                        content = curlCommands(project.getName(), URL);
                        Issue issue = issueFromJsonString(content);
                        issues.add(issue);
                    }
                    return issues;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            case 2:
                URL = buildURL(2);
                content = curlCommands(URL);
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
