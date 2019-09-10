package com.orange.malimacollector.controller;

import com.orange.malimacollector.entities.gitlab.Project;
import com.orange.malimacollector.service.gitlab.GitlabService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GitlabController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GitlabService gitlabService;

    @RequestMapping(method = RequestMethod.GET, value = "/project")
    public String projectPage(Model model){
        try {
            Project[] projects = gitlabService.handler();
            model.addAttribute("projects", projects);
        } catch (Exception e){
            LOGGER.error("Gitlab Controller:" + e.getMessage());
        }
        return "project";
    }
}
