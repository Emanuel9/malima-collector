package com.orange.malimacollector.controller;

import com.orange.malimacollector.config.MachineConfiguration;
import com.orange.malimacollector.entities.Status;
import com.orange.malimacollector.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StatusController {
    private static final String[] models = new String[]{
      "confluence", "gitlab", "jenkins", "jira", "mattermost", "rundeck", "sonar"
    };
    @Autowired
    StatusRepository statusRepository;

    @Autowired
    MachineConfiguration config;

    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public String checkStatus(Model model){
        for (int i = 0; i < 6; i++) {
            Status status = statusRepository.findByWebsiteAddress(this.config.getWebsites()[i].getLocalAddress());
            if (status != null){
                model.addAttribute(models[i], status.isRunning());
            }
        }
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/noService")
    public String noService(){
        return "noService";
    }
}
