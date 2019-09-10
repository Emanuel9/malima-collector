package com.orange.malimacollector;

import com.orange.malimacollector.entities.confluence.Page;
import com.orange.malimacollector.entities.confluence.Result;
import com.orange.malimacollector.entities.gitlab.Project;
import com.orange.malimacollector.entities.jenkins.JenkinsInfo;
import com.orange.malimacollector.entities.jenkins.PrimaryView;
import com.orange.malimacollector.entities.jira.Issue;
import com.orange.malimacollector.entities.mattermost.Teams;
import com.orange.malimacollector.entities.mattermost.User;
import com.orange.malimacollector.entities.sonar.Component;
import com.orange.malimacollector.entities.sonar.IssueElement;
import com.orange.malimacollector.service.Confluence.ConfluenceService;
import com.orange.malimacollector.service.Gitlab.GitlabService;
import com.orange.malimacollector.service.Jenkins.JenkinsService;
import com.orange.malimacollector.service.Jira.JiraService;
import com.orange.malimacollector.service.Mattermost.MattermostService;
import com.orange.malimacollector.service.Rundeck.RundeckService;
import com.orange.malimacollector.service.Sonar.SonarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationIntegrationTests {
    @MockBean
    private ConfluenceService confluenceServiceMock;

    @MockBean
    private GitlabService gitlabServiceMock;

    @MockBean
    private JenkinsService jenkinsServiceMock;

    @MockBean
    private JiraService jiraServiceMock;

    @MockBean
    private MattermostService mattermostServiceMock;

    @MockBean
    private RundeckService rundeckServiceMock;

    @MockBean
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
        Page page = new Page();
        page.setResults(results);
        given(confluenceServiceMock.handler(1)).willReturn(page);
        assertEquals(results.length, ((Page)confluenceServiceMock.handler(1)).getResults().length);
    }

    @Test
    public void testFetchingGitlabData(){
        Project[] projects = new Project[]{
                new Project(),
                new Project(),
                new Project()
        };
        given(gitlabServiceMock.handler()).willReturn(projects);
        assertEquals(projects.length, gitlabServiceMock.handler().length);
    }

    @Test
    public void testFetchingJenkinsData(){
        PrimaryView[] jobs = new PrimaryView[]{
                new PrimaryView()
        };
        JenkinsInfo jenkinsInfo = new JenkinsInfo();
        jenkinsInfo.setJobs(jobs);
        given(jenkinsServiceMock.handler(1)).willReturn(jenkinsInfo);
        assertEquals(jobs.length, ((JenkinsInfo)jenkinsServiceMock.handler(1)).getJobs().length);
    }

    @Test
    public void testFetchingJiraData(){
        com.orange.malimacollector.entities.jira.Project[] projects = new com.orange.malimacollector.entities.jira.Project[]{
          new com.orange.malimacollector.entities.jira.Project()
        };
        ArrayList<Issue> issueColl = new ArrayList<>();
        ArrayList<com.orange.malimacollector.entities.jira.IssueElement> issues = new ArrayList<>();
        for (int i = 0; i < 23; i++){
            issues.add(new com.orange.malimacollector.entities.jira.IssueElement());
        }
        com.orange.malimacollector.entities.jira.IssueElement[] issueElements = new com.orange.malimacollector.entities.jira.IssueElement[issues.size()];
        issueElements = issues.toArray(issueElements);
        Issue issue = new Issue();
        issue.setIssues(issueElements);
        issueColl.add(issue);
        given(jiraServiceMock.handler(2)).willReturn(projects);
        given(jiraServiceMock.handler(1)).willReturn(issueColl);
        assertEquals(projects.length,
                ((com.orange.malimacollector.entities.jira.Project[])jiraServiceMock.handler(2)).length);
        assertEquals(23, ((ArrayList<Issue>)jiraServiceMock.handler(1)).get(0).getIssues().length);
    }

    @Test
    public void testFetchingMattemostData(){
        User user = new User();
        Teams[] teams = new Teams[]{
          new Teams()
        };
        user.setUsername("alexm");
        given(mattermostServiceMock.handler(1)).willReturn(user);
        given(mattermostServiceMock.handler(2)).willReturn(teams);
        assertEquals(user.getUsername(), ((User)mattermostServiceMock.handler(1)).getUsername());
        assertEquals(teams.length, ((Teams[])mattermostServiceMock.handler(2)).length);
    }

    @Test
    public void testFetchingRundeckData(){
        com.orange.malimacollector.entities.rundeck.Project[] projects = new com.orange.malimacollector.entities.rundeck.Project[]{
                new com.orange.malimacollector.entities.rundeck.Project()
        };
        given(rundeckServiceMock.handler(1)).willReturn(projects);
        assertEquals(projects.length,
                ((com.orange.malimacollector.entities.rundeck.Project[])rundeckServiceMock.handler(1)).length);
    }

    @Test
    public void testFetchingSonarData(){
        com.orange.malimacollector.entities.sonar.Project project = new com.orange.malimacollector.entities.sonar.Project();
        Component[] components = new Component[]{
          new Component(), new Component()
        };
        project.setComponents(components);
        given(sonarServiceMock.handler(2)).willReturn(project);
        com.orange.malimacollector.entities.sonar.Issue issue = new com.orange.malimacollector.entities.sonar.Issue();
        ArrayList<IssueElement> issues = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            issues.add(new IssueElement());
        }
        IssueElement[] issueElements = new IssueElement[issues.size()];
        issueElements = issues.toArray(issueElements);
        issue.setIssues(issueElements);
        given(sonarServiceMock.handler(1)).willReturn(issue);
        assertEquals(2, ((com.orange.malimacollector.entities.sonar.Project)sonarServiceMock.handler(2)).getComponents().length);
        assertEquals(100, ((com.orange.malimacollector.entities.sonar.Issue)sonarServiceMock.handler(1)).getIssues().length);
    }
}
