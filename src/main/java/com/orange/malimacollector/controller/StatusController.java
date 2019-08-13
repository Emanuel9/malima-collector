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

    @RequestMapping(method = RequestMethod.GET, value = "/status")
    public String checkStatus(Model model){
        model.addAttribute("confluence", statusRepository.findByWebsiteAddress("http://localhost:8100").get().isRunning());
        model.addAttribute("gitlab", statusRepository.findByWebsiteAddress("http://gitlab.com").get().isRunning());
        model.addAttribute("jenkins", statusRepository.findByWebsiteAddress("http://localhost:8080").get().isRunning());
        model.addAttribute("jira", statusRepository.findByWebsiteAddress("http://localhost:8090").get().isRunning());
        model.addAttribute("mattermost", statusRepository.findByWebsiteAddress("http://localhost:8065").get().isRunning());
        model.addAttribute("rundeck", statusRepository.findByWebsiteAddress("http://localhost:4440").get().isRunning());
        model.addAttribute("sonar", statusRepository.findByWebsiteAddress("http://localhost:9000").get().isRunning());
        return "index";
    }
}
