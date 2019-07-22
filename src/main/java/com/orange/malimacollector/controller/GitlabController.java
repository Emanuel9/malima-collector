package com.orange.malimacollector.controller;

import com.orange.malimacollector.service.Gitlab.GitlabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GitlabController {

    @Autowired
    private GitlabService gitlabService;

    @PostMapping
    public void populateFields(){
        try {
            Object newInstance = gitlabService.handler();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }
}
