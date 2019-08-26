package com.orange.malimacollector;

import com.orange.malimacollector.entities.ConfluenceEntities.Page;
import com.orange.malimacollector.entities.ConfluenceEntities.Result;
import com.orange.malimacollector.entities.GitlabEntities.Project;
import com.orange.malimacollector.entities.JenkinsEntities.JenkinsInfo;
import com.orange.malimacollector.entities.JenkinsEntities.PrimaryView;
import com.orange.malimacollector.entities.JiraEntities.Issue;
import com.orange.malimacollector.entities.MattermostEntities.Teams;
import com.orange.malimacollector.entities.MattermostEntities.User;
import com.orange.malimacollector.entities.RundeckEntities.Job;
import com.orange.malimacollector.service.Confluence.ConfluenceService;
import com.orange.malimacollector.service.Gitlab.GitlabService;
import com.orange.malimacollector.service.Jenkins.JenkinsService;
import com.orange.malimacollector.service.Jira.JiraService;
import com.orange.malimacollector.service.Mattermost.MattermostService;
import com.orange.malimacollector.service.Rundeck.RundeckService;
import com.orange.malimacollector.service.Sonar.SonarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationIntegrationTests {
    @Autowired
    private ConfluenceService confluenceServiceMock;

    @Autowired
    private GitlabService gitlabServiceMock;

    @Autowired
    private JenkinsService jenkinsServiceMock;

    @Autowired
    private JiraService jiraServiceMock;

    @Autowired
    private MattermostService mattermostServiceMock;

    @Autowired
    private RundeckService rundeckServiceMock;

    @Autowired
    private SonarService sonarServiceMock;

    @Test
    public void testFetchingConfluenceData(){
        Result[] results = new Result[]{
                new Result(),
                new Result(),
                new Result(),
                new Result(),
                new Result(),
                new Result(),
                new Result(),
                new Result(),
                new Result(),
                new Result()
        };
        assertEquals(results.length, ((Page)confluenceServiceMock.handler(1)).getResults().length);
    }

    @Test
    public void testFetchingGitlabData(){
        assertEquals(new Project[]{
                new Project(),
                new Project(),
                new Project()
        }.length, gitlabServiceMock.handler().length);
    }

    @Test
    public void testFetchingJenkinsData(){
        PrimaryView[] jobs = new PrimaryView[]{
                new PrimaryView(),
                new PrimaryView(),
                new PrimaryView()
        };
        assertEquals(jobs.length, ((JenkinsInfo)jenkinsServiceMock.handler(1)).getJobs().length);
    }

    @Test
    public void testFetchingJiraData(){
        com.orange.malimacollector.entities.JiraEntities.Project[] projects = new com.orange.malimacollector.entities.JiraEntities.Project[]{
          new com.orange.malimacollector.entities.JiraEntities.Project()
        };
        assertEquals(projects.length,
                ((com.orange.malimacollector.entities.JiraEntities.Project[])jiraServiceMock.handler(2)).length);
        assertEquals(23, ((ArrayList<Issue>)jiraServiceMock.handler(1)).get(0).getIssues().length);
    }

    @Test
    public void testFetchingMattemostData(){
        assertEquals("alexm", ((User)mattermostServiceMock.handler(1)).getUsername());
        assertEquals(1, ((Teams[])mattermostServiceMock.handler(2)).length);
    }

    @Test
    public void testFetchingRundeckData(){
        assertEquals(1,
                ((com.orange.malimacollector.entities.RundeckEntities.Project[])rundeckServiceMock.handler(1)).length);
        ArrayList<Job[]> jobCollection = (ArrayList<Job[]>) rundeckServiceMock.handler(2);
        int size = 0;
        for (Job[] jobSet: jobCollection){
            size += jobSet.length;
        }
        assertEquals(1, size);
    }

    @Test
    public void testFetchingSonarData(){
        assertEquals(1, ((com.orange.malimacollector.entities.SonarEntities.Project)sonarServiceMock.handler(2)).getComponents().length);
        assertEquals(200, ((com.orange.malimacollector.entities.SonarEntities.Issue)sonarServiceMock.handler(1)).getIssues().length);
    }
}
