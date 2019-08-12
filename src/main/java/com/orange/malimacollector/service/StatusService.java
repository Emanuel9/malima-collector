package com.orange.malimacollector.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class StatusService {
    public static boolean isAccessible(String url) {
        url = url.replaceFirst("https", "http");

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url)
                    .openConnection();
            connection.setConnectTimeout(60 * 1000);
            connection.setReadTimeout(60 * 1000);
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
//            System.out.println("response code " + responseCode);
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
//        System.out.println("confluence");
//        System.out.println(isAccessible("http://localhost:8100"));
        return isAccessible("http://localhost:8100");
    }

    @Scheduled(fixedRate = 1000)
    public boolean gitlabCheck(){
//        System.out.println("gitlab");
//        System.out.println(isAccessible("http://gitlab.com"));
        return isAccessible("http://gitlab.com");
    }

    @Scheduled(fixedRate = 1000)
    public boolean jenkinsCheck(){
//        System.out.println("jenkins");
//        System.out.println(isAccessible("http://localhost:8080"));
        return isAccessible("http://localhost:8080");
    }

    @Scheduled(fixedRate = 1000)
    public boolean jiraCheck(){
//        System.out.println("jira");
//        System.out.println(isAccessible("http://localhost:8090"));
        return isAccessible("http://localhost:8090");
    }

    @Scheduled(fixedRate = 1000)
    public boolean mattermostCheck(){
//        System.out.println("mattermost");
//        System.out.println(isAccessible("http://localhost:8065"));
        return isAccessible("http://localhost:8065");
    }

    @Scheduled(fixedRate = 1000)
    public boolean rundeckCheck(){
//        System.out.println("rundeck");
//        System.out.println(isAccessible("http://localhost:4440"));
        return isAccessible("http://localhost:4440");
    }

    @Scheduled(fixedRate = 1000)
    public boolean sonarCheck(){
//        System.out.println("sonar");
//        System.out.println(isAccessible("http://localhost:9000"));
        return isAccessible("http://localhost:9000");
    }
}
