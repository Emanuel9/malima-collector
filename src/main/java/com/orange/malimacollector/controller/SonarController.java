package com.orange.malimacollector.controller;

import com.orange.malimacollector.entities.sonar.Issue;
import com.orange.malimacollector.entities.sonar.Project;
import com.orange.malimacollector.service.sonar.SonarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SonarController {
    @Autowired
    SonarService sonarService;

    @RequestMapping(method = RequestMethod.GET, value = "/sonar")
    public String sonarDisplay(Model model){
        Project project = (Project) sonarService.handler(2);
        model.addAttribute("project", project);
        Issue issue = (Issue) sonarService.handler(1);
        model.addAttribute("issue", issue);
        return "sonar";
    }
}
