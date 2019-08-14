package com.orange.malimacollector.service;

import com.orange.malimacollector.entities.Status;
import com.orange.malimacollector.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.Optional;

@Component
public class StatusService {
    @Autowired
    StatusRepository statusRepository;

    public Status saveStatus(Status status){
        Optional<Status> statusOptional = statusRepository.findByWebsiteAddress(status.getWebsiteAddress());
        if (statusOptional.isPresent()){
            return statusOptional.get();
        }
        status.setRunning(statusCode(curlCommand(status.getCommand())).equals("200") ? "true" : "false");
        status = statusRepository.saveAndFlush(status);
        return status;
    }

    public String statusCode(String response){
        String[] responseParameters = response.split(" ");
        try {
            return responseParameters[1].trim();
        } catch (Exception e) {
            return "404";
        }
    }

    public static boolean isAccessible(String url) {
        url = url.replaceFirst("https", "http");

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url)
                    .openConnection();
            connection.setConnectTimeout(60 * 1000);
            connection.setReadTimeout(60 * 1000);
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                return false;
            }
        } catch (IOException exception) {
            return false;
        }
        return true;
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
    public boolean confluenceCheck(){
        Status status = new Status("http://localhost:8100");
        status.setCommand("curl -i -u alexm:admin -G \"http://localhost:8100/rest/api/content/search\" --data-urlencode \"cql=(type=page and space=ds)\"");
        return saveStatus(status).isRunning().equals("true");
    }

    @Scheduled(fixedRate = 1000)
    public boolean gitlabCheck(){
        Status status = new Status("http://gitlab.com");
        status.setCommand("curl -i https://gitlab.com/api/v4/users/4278148/projects?private_token=8aHcnAb8eVSjauuSkQj7");
        return saveStatus(status).isRunning().equals("true");
    }

    @Scheduled(fixedRate = 1000)
    public boolean jenkinsCheck(){
        Status status = new Status("http://localhost:8080");
        status.setCommand("curl -i -u alexm:admin http://localhost:8080/api/json?pretty=true");
        return saveStatus(status).isRunning().equals("true");
    }

    @Scheduled(fixedRate = 1000)
    public boolean jiraCheck(){
        Status status = new Status("http://localhost:8090");
        status.setCommand("curl -i -u alexm:admin http://localhost:8090/rest/api/2/project");
        return saveStatus(status).isRunning().equals("true");
    }

    @Scheduled(fixedRate = 1000)
    public boolean mattermostCheck(){
        Status status = new Status("http://localhost:8065");
        status.setCommand("curl -i -d \"{\\\"login_id\\\":\\\"alexm\\\",\\\"password\\\":\\\"mz-789\\\"}\" http://localhost:8065/api/v4/users/login");
        return saveStatus(status).isRunning().equals("true");
    }

    @Scheduled(fixedRate = 1000)
    public boolean rundeckCheck(){
        Status status = new Status("http://localhost:4440");
        status.setCommand("curl -i http://localhost:4440");
        return saveStatus(status).isRunning().equals("true");
    }

    @Scheduled(fixedRate = 1000)
    public boolean sonarCheck(){
        Status status = new Status("http://localhost:9000");
        status.setCommand("curl -i -u admin:admin http://localhost:9000/api/server");
        return saveStatus(status).isRunning().equals("true");
    }
}
