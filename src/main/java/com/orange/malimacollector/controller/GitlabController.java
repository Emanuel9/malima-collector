package com.orange.malimacollector.controller;

import com.orange.malimacollector.entities.GitlabEntities.Project;
import com.orange.malimacollector.service.Gitlab.GitlabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GitlabController {

    @Autowired
    private GitlabService gitlabService;

    @RequestMapping(method = RequestMethod.GET, value = "/project")
    public String projectPage(Model model){
        try {
            Project[] projects = gitlabService.handler();
            model.addAttribute("projects", projects);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "project";
    }
}
