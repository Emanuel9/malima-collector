package com.orange.malimacollector.service;

import com.orange.malimacollector.config.MachineConfiguration;
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

    @Autowired
    MachineConfiguration config;

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
        Status status = new Status(this.config.getWebsites()[0].getLocalAddress(), this.config.getWebsites()[0].getWebsiteName());
        status.setCommand("curl -i -u " + this.config.getWebsites()[0].getAdminUsername() + ":" +
                 this.config.getWebsites()[0].getAdminPassword() + " -G \""+ this.config.getWebsites()[0].getLocalAddress()
                + "/search\" --data-urlencode \"cql=(type=page and space=ds)\"");
        saveStatus(status);
    }

    @Scheduled(fixedRate = 1000)
    public void gitlabCheck(){
        Status status = new Status(this.config.getWebsites()[1].getLocalAddress(), this.config.getWebsites()[1].getWebsiteName());
        status.setCommand("curl -i " + this.config.getWebsites()[1].getLocalAddress() + "users/" + this.config.getWebsites()[1].getAdminUsername() +
                        "/projects?private_token=" + this.config.getWebsites()[1].getAdminPassword());
        saveStatus(status);
    }

    @Scheduled(fixedRate = 1000)
    public void jenkinsCheck(){
        Status status = new Status(this.config.getWebsites()[2].getLocalAddress(), this.config.getWebsites()[2].getWebsiteName());
        status.setCommand("curl -i -u " + this.config.getWebsites()[2].getAdminUsername() + ":" +
                this.config.getWebsites()[2].getAdminPassword() + " " +
                this.config.getWebsites()[2].getLocalAddress() + "api/json?pretty=true");
        saveStatus(status);
    }

    @Scheduled(fixedRate = 1000)
    public void jiraCheck(){
        Status status = new Status(this.config.getWebsites()[3].getLocalAddress(), this.config.getWebsites()[3].getWebsiteName());
        status.setCommand("curl -i -u " + this.config.getWebsites()[3].getAdminUsername() + ":" +
                this.config.getWebsites()[3].getAdminPassword() + " " + this.config.getWebsites()[3].getLocalAddress() + "project");
        saveStatus(status);
    }

    @Scheduled(fixedRate = 1000)
    public void mattermostCheck(){
        Status status = new Status(this.config.getWebsites()[4].getLocalAddress(), this.config.getWebsites()[4].getWebsiteName());
        status.setCommand("curl -i -d \"{\\\"login_id\\\":\\\"" + this.config.getWebsites()[4].getAdminUsername() +
                "\\\",\\\"password\\\":\\\"" + this.config.getWebsites()[4].getAdminPassword() + "\\\"}\" " +
                this.config.getWebsites()[4].getLocalAddress() + "users/login");
        saveStatus(status);
    }

    @Scheduled(fixedRate = 1000)
    public void rundeckCheck(){
        Status status = new Status(this.config.getWebsites()[5].getLocalAddress(), this.config.getWebsites()[5].getWebsiteName());
        status.setCommand("curl -i " + this.config.getWebsites()[5].getLocalAddress() + "user/login");
        saveStatus(status);
    }

    @Scheduled(fixedRate = 1000)
    public void sonarCheck(){
        Status status = new Status(this.config.getWebsites()[6].getLocalAddress(), this.config.getWebsites()[6].getWebsiteName());
        status.setCommand("curl -i -u " + this.config.getWebsites()[6].getAdminUsername() + ":" +
                this.config.getWebsites()[6].getAdminPassword() + " " + this.config.getWebsites()[6].getLocalAddress() + "server");
        saveStatus(status);
    }
}
