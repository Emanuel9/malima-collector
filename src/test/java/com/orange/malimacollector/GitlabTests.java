package com.orange.malimacollector;

import com.orange.malimacollector.controller.GitlabController;
import com.orange.malimacollector.entities.GitlabEntities.Project;
import com.orange.malimacollector.service.Gitlab.GitlabService;
import org.junit.Test;
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
@WebMvcTest(GitlabController.class)
public class GitlabTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private GitlabService gitlabService;

    @Test
    public void testGitlabInformation() throws Exception {
        Project firstProject = new Project();
        firstProject.setName("TestProject");
        Project secondProject = new Project();
        secondProject.setName("TestProject2");
        Project thirdProject = new Project();
        thirdProject.setName("TestProject3");

        Project[] testProjects = new Project[]{
                firstProject, secondProject, thirdProject
        };

        given(gitlabService.handler()).willReturn(testProjects);

        mvc.perform(get("/project").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }
}
