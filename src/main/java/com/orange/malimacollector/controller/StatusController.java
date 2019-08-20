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
        if (statusRepository.findByWebsiteAddress("http://localhost:8100").isPresent()) {
            model.addAttribute("confluence", statusRepository.findByWebsiteAddress("http://localhost:8100").get().isRunning());
        }
        if(statusRepository.findByWebsiteAddress("http://gitlab.com").isPresent()) {
            model.addAttribute("gitlab", statusRepository.findByWebsiteAddress("http://gitlab.com").get().isRunning());
        }
        if (statusRepository.findByWebsiteAddress("http://localhost:8080").isPresent()) {
            model.addAttribute("jenkins", statusRepository.findByWebsiteAddress("http://localhost:8080").get().isRunning());
        }
        if (statusRepository.findByWebsiteAddress("http://localhost:8090").isPresent()) {
            model.addAttribute("jira", statusRepository.findByWebsiteAddress("http://localhost:8090").get().isRunning());
        }
        if (statusRepository.findByWebsiteAddress("http://localhost:8065").isPresent()) {
            model.addAttribute("mattermost", statusRepository.findByWebsiteAddress("http://localhost:8065").get().isRunning());
        }
        if(statusRepository.findByWebsiteAddress("http://localhost:4440").isPresent()) {
            model.addAttribute("rundeck", statusRepository.findByWebsiteAddress("http://localhost:4440").get().isRunning());
        }
        if(statusRepository.findByWebsiteAddress("http://localhost:9000").isPresent()) {
            model.addAttribute("sonar", statusRepository.findByWebsiteAddress("http://localhost:9000").get().isRunning());
        }
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/noService")
    public String noService(){
        return "noService";
    }
}
