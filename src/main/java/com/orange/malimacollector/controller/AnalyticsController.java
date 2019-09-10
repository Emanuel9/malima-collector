package com.orange.malimacollector.controller;

import com.orange.malimacollector.entities.confluence.Page;
import com.orange.malimacollector.entities.jenkins.JenkinsInfo;
import com.orange.malimacollector.entities.jira.Issue;
import com.orange.malimacollector.entities.jira.Project;
import com.orange.malimacollector.entities.mattermost.Teams;
import com.orange.malimacollector.entities.rundeck.Job;
import com.orange.malimacollector.service.confluence.ConfluenceService;
import com.orange.malimacollector.service.gitlab.GitlabService;
import com.orange.malimacollector.service.jenkins.JenkinsService;
import com.orange.malimacollector.service.jira.JiraService;
import com.orange.malimacollector.service.mattermost.MattermostService;
import com.orange.malimacollector.service.rundeck.RundeckService;
import com.orange.malimacollector.service.sonar.SonarService;
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
        int confluencePages = ((Page)confluenceService.handler()).getResults().length;
        model.addAttribute("confluencePages", confluencePages);

        int gitlabProjects = gitlabService.handler().length;
        model.addAttribute("gitlabProjects", gitlabProjects);

        int jenkinsJobs = ((JenkinsInfo)jenkinsService.handler()).getJobs().length;
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

        int rundeckProjects = ((com.orange.malimacollector.entities.rundeck.Project[]) rundeckService.handler(1)).length;
        model.addAttribute("rundeckProjects", rundeckProjects);
        ArrayList<Job[]> jobCollection = (ArrayList<Job[]>) rundeckService.handler(2);
        int size = 0;
        for (Job[] jobs: jobCollection){
            size += jobs.length;
        }
        model.addAttribute("rundeckJobs", size);

        int sonarProjects = ((com.orange.malimacollector.entities.sonar.Project) sonarService.handler(2)).getComponents().length;
        model.addAttribute("sonarProjects", sonarProjects);
        int sonarIssues = ((com.orange.malimacollector.entities.sonar.Issue) sonarService.handler(1)).getIssues().length;
        model.addAttribute("sonarIssues", sonarIssues);
        return "analytics";
    }
}
