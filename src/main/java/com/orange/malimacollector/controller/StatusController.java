package com.orange.malimacollector.controller;

import com.orange.malimacollector.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StatusController {
    @Autowired
    StatusService statusService;

    @RequestMapping(method = RequestMethod.GET, value = "/status")
    public String checkStatus(Model model){
        model.addAttribute("confluence", statusService.confluenceCheck());
        model.addAttribute("gitlab", statusService.gitlabCheck());
        model.addAttribute("jenkins", statusService.jenkinsCheck());
        model.addAttribute("jira", statusService.jiraCheck());
        model.addAttribute("mattermost", statusService.mattermostCheck());
        model.addAttribute("rundeck", statusService.rundeckCheck());
        model.addAttribute("sonar", statusService.sonarCheck());
        return "index";
    }
}
