package com.orange.malimacollector.controller;

import com.orange.malimacollector.entities.JiraEntities.Issue;
import com.orange.malimacollector.entities.JiraEntities.Project;
import com.orange.malimacollector.service.Jira.JiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class JiraController {
    @Autowired
    JiraService jiraService;

    @RequestMapping(method = RequestMethod.GET, value = "/jira")
    public String jiraDisplay(Model model){
        Project[] projects = (Project[]) jiraService.handler(2);
        model.addAttribute("projects", projects);
        ArrayList<Issue> issues = (ArrayList<Issue>) jiraService.handler(1);
        model.addAttribute("issues", issues);
        return "jira";
    }
}
