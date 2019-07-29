package com.orange.malimacollector.controller;

import com.orange.malimacollector.entities.RundeckEntities.Job;
import com.orange.malimacollector.entities.RundeckEntities.Project;
import com.orange.malimacollector.service.Rundeck.RundeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class RundeckController {
    @Autowired
    RundeckService rundeckService;

    @RequestMapping(method = RequestMethod.GET, value = "/rundeck")
    public String rundeckDisplay(Model model){
        Project[] projects = (Project[]) rundeckService.handler(1);
        model.addAttribute("projects", projects);
        ArrayList<Job[]> jobCollection = (ArrayList<Job[]>) rundeckService.handler(2);
        int i = 0, size = 0;
        for (Job[] jobs: jobCollection){
            size += jobs.length;
        }
        Job[] totalJobs = new Job[size];
        for (Job[] jobs: jobCollection) {
            for (int j = 0; j < jobs.length; j++, i++) {
                totalJobs[i] = jobs[j];
            }
        }
        model.addAttribute("jobs",totalJobs);
        return "rundeck";
    }
}