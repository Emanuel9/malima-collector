package com.orange.malimacollector.service;

import com.orange.malimacollector.entities.Status;
import com.orange.malimacollector.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Paths;

@Component
public class StatusService {
    @Autowired
    StatusRepository statusRepository;

    public void saveStatus(Status status){
        Status statusOptional = statusRepository.findByWebsiteAddress(status.getWebsiteAddress());
        status.setRunning(statusCode(curlCommand(status.getCommand())).equals("200") ? "true" : "false");

        if (statusOptional != null){
            statusRepository.setRunningStatus(status.isRunning(), statusOptional.getWebsiteID());
        } else {
            statusRepository.saveAndFlush(status);
        }
    }

    public String statusCode(String response){
        String[] responseParameters = response.split(" ");
        try {
            return responseParameters[1].trim();
        } catch (Exception e) {
            return "404";
        }
    }

    public String curlCommand(String command) {
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

    @Scheduled(fixedRate = 1000)
    public void confluenceCheck(){
        Status status = new Status("http://localhost:8100", "Confluence");
        status.setCommand("curl -i -u alexm:admin -G \"http://localhost:8100/rest/api/content/search\" --data-urlencode \"cql=(type=page and space=ds)\"");
        saveStatus(status);
    }

    @Scheduled(fixedRate = 1000)
    public void gitlabCheck(){
        Status status = new Status("http://gitlab.com", "Gitlab");
        status.setCommand("curl -i https://gitlab.com/api/v4/users/4278148/projects?private_token=8aHcnAb8eVSjauuSkQj7");
        saveStatus(status);
    }

    @Scheduled(fixedRate = 1000)
    public void jenkinsCheck(){
        Status status = new Status("http://localhost:8080", "Jenkins");
        status.setCommand("curl -i -u alexm:admin http://localhost:8080/api/json?pretty=true");
        saveStatus(status);
    }

    @Scheduled(fixedRate = 1000)
    public void jiraCheck(){
        Status status = new Status("http://localhost:8090", "Jira");
        status.setCommand("curl -i -u alexm:admin http://localhost:8090/rest/api/2/project");
        saveStatus(status);
    }

    @Scheduled(fixedRate = 1000)
    public void mattermostCheck(){
        Status status = new Status("http://localhost:8065", "Mattermost");
        status.setCommand("curl -i -d \"{\\\"login_id\\\":\\\"alexm\\\",\\\"password\\\":\\\"mz-789\\\"}\" http://localhost:8065/api/v4/users/login");
        saveStatus(status);
    }

    @Scheduled(fixedRate = 1000)
    public void rundeckCheck(){
        Status status = new Status("http://localhost:4440", "Rundeck");
        status.setCommand("curl -i http://localhost:4440/user/login");
        saveStatus(status);
    }

    @Scheduled(fixedRate = 1000)
    public void sonarCheck(){
        Status status = new Status("http://localhost:9000", "Sonar");
        status.setCommand("curl -i -u admin:admin http://localhost:9000/api/server");
        saveStatus(status);
    }
}
