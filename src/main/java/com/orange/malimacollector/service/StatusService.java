package com.orange.malimacollector.service;

import com.orange.malimacollector.entities.Status;
import com.orange.malimacollector.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
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
        status.setRunning(isAccessible(status.getWebsiteAddress()) ? "true" : "false");
        status = statusRepository.saveAndFlush(status);
        return status;
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

    @Scheduled(fixedRate = 1000)
    public boolean confluenceCheck(){
        Status status = new Status("http://localhost:8100");
        return saveStatus(status).isRunning().equals("true");
    }

    @Scheduled(fixedRate = 1000)
    public boolean gitlabCheck(){
        Status status = new Status("http://gitlab.com");
        return saveStatus(status).isRunning().equals("true");
    }

    @Scheduled(fixedRate = 1000)
    public boolean jenkinsCheck(){
        Status status = new Status("http://localhost:8080");
        return saveStatus(status).isRunning().equals("true");
    }

    @Scheduled(fixedRate = 1000)
    public boolean jiraCheck(){
        Status status = new Status("http://localhost:8090");
        return saveStatus(status).isRunning().equals("true");
    }

    @Scheduled(fixedRate = 1000)
    public boolean mattermostCheck(){
        Status status = new Status("http://localhost:8065");
        return saveStatus(status).isRunning().equals("true");
    }

    @Scheduled(fixedRate = 1000)
    public boolean rundeckCheck(){
        Status status = new Status("http://localhost:4440");
        return saveStatus(status).isRunning().equals("true");
    }

    @Scheduled(fixedRate = 1000)
    public boolean sonarCheck(){
        Status status = new Status("http://localhost:9000");
        return saveStatus(status).isRunning().equals("true");
    }
}
