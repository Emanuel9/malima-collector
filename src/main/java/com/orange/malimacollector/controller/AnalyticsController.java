package com.orange.malimacollector.controller;

import com.orange.malimacollector.entities.ConfluenceEntities.Page;
import com.orange.malimacollector.entities.JenkinsEntities.JenkinsInfo;
import com.orange.malimacollector.entities.JiraEntities.Issue;
import com.orange.malimacollector.entities.JiraEntities.Project;
import com.orange.malimacollector.entities.MattermostEntities.Teams;
import com.orange.malimacollector.entities.RundeckEntities.Job;
import com.orange.malimacollector.service.Confluence.ConfluenceService;
import com.orange.malimacollector.service.Gitlab.GitlabService;
import com.orange.malimacollector.service.Jenkins.JenkinsService;
import com.orange.malimacollector.service.Jira.JiraService;
import com.orange.malimacollector.service.Mattermost.MattermostService;
import com.orange.malimacollector.service.Rundeck.RundeckService;
import com.orange.malimacollector.service.Sonar.SonarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class AnalyticsController {
    @Autowired
    ConfluenceService confluenceService;

    @Autowired
    GitlabService gitlabService;

    @Autowired
    JenkinsService jenkinsService;

    @Autowired
    JiraService jiraService;

    @Autowired
    MattermostService mattermostService;

    @Autowired
    RundeckService rundeckService;

    @Autowired
    SonarService sonarService;

    @RequestMapping(method = RequestMethod.GET, value = "/analytics")
    public String analyticsView(Model model){
        int confluencePages = ((Page)confluenceService.handler(1)).getResults().length;
        model.addAttribute("confluencePages", confluencePages);

        int gitlabProjects = gitlabService.handler().length;
        model.addAttribute("gitlabProjects", gitlabProjects);

        int jenkinsJobs = ((JenkinsInfo)jenkinsService.handler(1)).getJobs().length;
        model.addAttribute("jenkinsJobs", jenkinsJobs);

        int jiraProjects = ((Project[]) jiraService.handler(2)).length;
        model.addAttribute("jiraProjects", jiraProjects);
        int jiraIssues = ((ArrayList<Issue>) jiraService.handler(1)).size();
        model.addAttribute("jiraIssues", jiraIssues);

        Teams[] teams = (Teams[]) mattermostService.handler(2);
        ArrayList<String> posts= new ArrayList<>();
        for (Teams team: teams){
            posts.addAll(mattermostService.handler("test", team));
        }
        int mattermostPosts = posts.size();
        model.addAttribute("mattermostPosts", mattermostPosts);

        int rundeckProjects = ((com.orange.malimacollector.entities.RundeckEntities.Project[]) rundeckService.handler(1)).length;
        model.addAttribute("rundeckProjects", rundeckProjects);
        ArrayList<Job[]> jobCollection = (ArrayList<Job[]>) rundeckService.handler(2);
        int size = 0;
        for (Job[] jobs: jobCollection){
            size += jobs.length;
        }
        model.addAttribute("rundeckJobs", size);

        int sonarProjects = ((com.orange.malimacollector.entities.SonarEntities.Project) sonarService.handler(2)).getComponents().length;
        model.addAttribute("sonarProjects", sonarProjects);
        int sonarIssues = ((com.orange.malimacollector.entities.SonarEntities.Issue) sonarService.handler(1)).getIssues().length;
        model.addAttribute("sonarIssues", sonarIssues);
        return "analytics";
    }
}
