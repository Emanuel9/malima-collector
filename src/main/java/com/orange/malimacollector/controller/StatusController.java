package com.orange.malimacollector.controller;

import com.orange.malimacollector.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StatusController {
    @Autowired
    StatusRepository statusRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public String checkStatus(Model model){
        if (statusRepository.findByWebsiteAddress("http://localhost:8100") != null) {
            model.addAttribute("confluence", statusRepository.findByWebsiteAddress("http://localhost:8100").isRunning());
        }
        if(statusRepository.findByWebsiteAddress("http://gitlab.com") != null) {
            model.addAttribute("gitlab", statusRepository.findByWebsiteAddress("http://gitlab.com").isRunning());
        }
        if (statusRepository.findByWebsiteAddress("http://localhost:8080") != null) {
            model.addAttribute("jenkins", statusRepository.findByWebsiteAddress("http://localhost:8080").isRunning());
        }
        if (statusRepository.findByWebsiteAddress("http://localhost:8090") != null) {
            model.addAttribute("jira", statusRepository.findByWebsiteAddress("http://localhost:8090").isRunning());
        }
        if (statusRepository.findByWebsiteAddress("http://localhost:8065") != null) {
            model.addAttribute("mattermost", statusRepository.findByWebsiteAddress("http://localhost:8065").isRunning());
        }
        if(statusRepository.findByWebsiteAddress("http://localhost:4440") != null) {
            model.addAttribute("rundeck", statusRepository.findByWebsiteAddress("http://localhost:4440").isRunning());
        }
        if(statusRepository.findByWebsiteAddress("http://localhost:9000") != null) {
            model.addAttribute("sonar", statusRepository.findByWebsiteAddress("http://localhost:9000").isRunning());
        }
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/noService")
    public String noService(){
        return "noService";
    }
}
