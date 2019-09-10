package com.orange.malimacollector.controller;

import com.orange.malimacollector.entities.jenkins.JenkinsInfo;
import com.orange.malimacollector.entities.jenkins.PrimaryView;
import com.orange.malimacollector.service.jenkins.JenkinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JenkinsController {
    @Autowired
    JenkinsService jenkinsService;

    @RequestMapping(method = RequestMethod.GET, value = "/jenkins")
    public String jenkinsDisplay(Model model){
        PrimaryView[] jobs = ((JenkinsInfo)jenkinsService.handler(1)).getJobs();
        model.addAttribute("jobs", jobs);
        return "jenkins";
    }
}
