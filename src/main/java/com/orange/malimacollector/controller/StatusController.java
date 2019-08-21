package com.orange.malimacollector.controller;

import com.orange.malimacollector.config.MachineConfiguration;
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

    @Autowired
    MachineConfiguration config;

    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public String checkStatus(Model model){
        if (statusRepository.findByWebsiteAddress(this.config.getWebsites()[0].getLocalAddress()) != null) {
            model.addAttribute("confluence", statusRepository.findByWebsiteAddress(this.config.getWebsites()[0].getLocalAddress()).isRunning());
        }
        if(statusRepository.findByWebsiteAddress(this.config.getWebsites()[1].getLocalAddress()) != null) {
            model.addAttribute("gitlab", statusRepository.findByWebsiteAddress(this.config.getWebsites()[1].getLocalAddress()).isRunning());
        }
        if (statusRepository.findByWebsiteAddress(this.config.getWebsites()[2].getLocalAddress()) != null) {
            model.addAttribute("jenkins", statusRepository.findByWebsiteAddress(this.config.getWebsites()[2].getLocalAddress()).isRunning());
        }
        if (statusRepository.findByWebsiteAddress(this.config.getWebsites()[3].getLocalAddress()) != null) {
            model.addAttribute("jira", statusRepository.findByWebsiteAddress(this.config.getWebsites()[3].getLocalAddress()).isRunning());
        }
        if (statusRepository.findByWebsiteAddress(this.config.getWebsites()[4].getLocalAddress()) != null) {
            model.addAttribute("mattermost", statusRepository.findByWebsiteAddress(this.config.getWebsites()[4].getLocalAddress()).isRunning());
        }
        if(statusRepository.findByWebsiteAddress(this.config.getWebsites()[5].getLocalAddress()) != null) {
            model.addAttribute("rundeck", statusRepository.findByWebsiteAddress(this.config.getWebsites()[5].getLocalAddress()).isRunning());
        }
        if(statusRepository.findByWebsiteAddress(this.config.getWebsites()[6].getLocalAddress()) != null) {
            model.addAttribute("sonar", statusRepository.findByWebsiteAddress(this.config.getWebsites()[6].getLocalAddress()).isRunning());
        }
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/noService")
    public String noService(){
        return "noService";
    }
}
