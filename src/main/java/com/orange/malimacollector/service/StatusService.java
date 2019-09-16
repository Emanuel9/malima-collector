package com.orange.malimacollector.service;

import com.orange.malimacollector.config.MachineConfiguration;
import com.orange.malimacollector.entities.Status;
import com.orange.malimacollector.repositories.StatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StatusService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private MachineConfiguration config;

    public void saveStatus(Status status){
        Status statusOptional = statusRepository.findByWebsiteAddress(status.getWebsiteAddress());
        try {
            status.setRunning(getData(status) == 200 ? "true" : "false");
        } catch (Exception e) {
            status.setRunning("false");
            logger.error("Status Error:" + e.getMessage());
        }

        if (statusOptional != null){
            statusRepository.setRunningStatus(status.isRunning(), statusOptional.getWebsiteID());
        } else {
            statusRepository.saveAndFlush(status);
        }
    }

    public int getData(Status status){
        int index = status.getWebsiteIndex();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response;
        if (index == 1 || index == 5){
            response = restTemplate.exchange(status.getWebsiteCheck(), HttpMethod.GET, null, String.class);
        } else if (index == 4){
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + this.config.getWebsites()[index].getAdminPassword());
            HttpEntity<String> entity = new HttpEntity<>(null, headers);
            response = restTemplate.exchange(status.getWebsiteCheck(), HttpMethod.GET, entity, String.class);
        } else {
            restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(this.config.getWebsites()[index].getAdminUsername(),
                    this.config.getWebsites()[index].getAdminPassword()));
            response = restTemplate.exchange(status.getWebsiteCheck(), HttpMethod.GET, null, String.class);
        }
        return response.getStatusCodeValue();
    }

    @Scheduled(fixedRate = 1000)
    public void confluenceCheck(){
        Status status = new Status(this.config.getWebsites()[0].getLocalAddress(), this.config.getWebsites()[0].getWebsiteName());
        status.setWebsiteCheck(this.config.getWebsites()[0].getLocalAddress() + "/search?cql=(type=page and space=ds)");
        status.setWebsiteIndex(0);
        saveStatus(status);
    }

    @Scheduled(initialDelay = 500, fixedRate = 1000)
    public void gitlabCheck(){
        Status status = new Status(this.config.getWebsites()[1].getLocalAddress(), this.config.getWebsites()[1].getWebsiteName());
        status.setWebsiteCheck(this.config.getWebsites()[1].getLocalAddress() + "users/" + this.config.getWebsites()[1].getAdminUsername() +
                "/projects?private_token=" + this.config.getWebsites()[1].getAdminPassword());
        status.setWebsiteIndex(1);
        saveStatus(status);
    }

    @Scheduled(initialDelay = 1000, fixedRate = 1000)
    public void jenkinsCheck(){
        Status status = new Status(this.config.getWebsites()[2].getLocalAddress(), this.config.getWebsites()[2].getWebsiteName());
        status.setWebsiteCheck(this.config.getWebsites()[2].getLocalAddress() + "api/json?pretty=true");
        status.setWebsiteIndex(2);
        saveStatus(status);
    }

    @Scheduled(initialDelay = 1500, fixedRate = 1000)
    public void jiraCheck(){
        Status status = new Status(this.config.getWebsites()[3].getLocalAddress(), this.config.getWebsites()[3].getWebsiteName());
        status.setWebsiteCheck(this.config.getWebsites()[3].getLocalAddress() + "project");
        status.setWebsiteIndex(3);
        saveStatus(status);
    }

    @Scheduled(initialDelay = 2000, fixedRate = 1000)
    public void mattermostCheck(){
        Status status = new Status(this.config.getWebsites()[4].getLocalAddress(), this.config.getWebsites()[4].getWebsiteName());
        status.setWebsiteCheck(this.config.getWebsites()[4].getLocalAddress() + "users/me");
        status.setWebsiteIndex(4);
        saveStatus(status);
    }

    @Scheduled(initialDelay = 2500, fixedRate = 1000)
    public void rundeckCheck(){
        Status status = new Status(this.config.getWebsites()[5].getLocalAddress(), this.config.getWebsites()[5].getWebsiteName());
        status.setWebsiteCheck(this.config.getWebsites()[5].getLocalAddress() + "user/login");
        status.setWebsiteIndex(5);
        saveStatus(status);
    }

    @Scheduled(initialDelay = 3000, fixedRate = 1000)
    public void sonarCheck(){
        Status status = new Status(this.config.getWebsites()[6].getLocalAddress(), this.config.getWebsites()[6].getWebsiteName());
        status.setWebsiteCheck(this.config.getWebsites()[6].getLocalAddress() + "projects/search");
        status.setWebsiteIndex(6);
        saveStatus(status);
    }
}
