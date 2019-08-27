package com.orange.malimacollector.controller;

import com.orange.malimacollector.entities.ConfluenceEntities.Page;
import com.orange.malimacollector.service.Confluence.ConfluenceService;
import com.orange.malimacollector.service.Gitlab.GitlabService;
import com.orange.malimacollector.service.Jenkins.JenkinsService;
import com.orange.malimacollector.service.Jira.JiraService;
import com.orange.malimacollector.service.Mattermost.MattermostService;
import com.orange.malimacollector.service.Rundeck.RundeckService;
import com.orange.malimacollector.service.Sonar.SonarService;
import com.orange.malimacollector.service.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AnalyticsController.class)
class AnalyticsControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @MockBean
    private ConfluenceService confluenceService;

    @MockBean
    private GitlabService gitlabService;

    @MockBean
    private JenkinsService jenkinsService;

    @MockBean
    private JiraService jiraService;

    @MockBean
    private MattermostService mattermostService;

    @MockBean
    private RundeckService rundeckService;

    @MockBean
    private SonarService sonarService;

    @Test
    void analyticsView() throws Exception {
        given(((Page)confluenceService.handler(1)).getResults().length).willReturn(10);
        mvc.perform(get("/confluence").contentType(MediaType.ALL))
                .andExpect(status().isOk());
    }
}