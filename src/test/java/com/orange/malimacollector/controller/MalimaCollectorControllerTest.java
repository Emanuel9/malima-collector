package com.orange.malimacollector.controller;

import com.orange.malimacollector.dao.AppUserDAO;
import com.orange.malimacollector.entities.login.AppUser;
import com.orange.malimacollector.model.AppUserForm;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.servlet.View;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class MalimaCollectorControllerTest {
    @InjectMocks
    MalimaCollectorController controller;

    @Autowired
    MockMvc mvc;

    @MockBean
    View mockView;

    @Autowired
    private AppUserDAO appUserDAO;


    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        StandaloneMockMvcBuilder standaloneMockMvcBuilder = standaloneSetup(controller);
        standaloneMockMvcBuilder.setSingleView(mockView);
        mvc = standaloneMockMvcBuilder.build();
    }


    @Test
    void welcomePage() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    void viewMembers() throws Exception {
        mvc.perform(get("/members"))
                .andExpect(status().isOk());
    }

    @Test
    void viewRegisterSuccessful() throws Exception {
        mvc.perform(get("/registerSuccessful"))
                .andExpect(status().isOk());
    }

    @Test
    void viewRegister() throws Exception {
        mvc.perform(get("/register"))
                .andExpect(status().isOk());
    }

    @Test
    void saveRegister() throws Exception {
        AppUserForm form = new AppUserForm(1L,"test",true,"test","test","test");
        AppUser newUser = appUserDAO.createAppUser(form);
        mvc.perform(post("/register", newUser))
                .andExpect(status().isOk());
    }

    @Test
    void adminPage() throws Exception {
        mvc.perform(get("/login"))
                .andExpect(status().isOk());
    }

    @Test
    void loginPage() throws Exception {
        mvc.perform(get("/login"))
                .andExpect(status().isOk());
    }

    @Test
    void logoutSuccessfulPage() throws Exception {
        mvc.perform(get("/logoutSuccessful"))
                .andExpect(status().isOk());
    }

    @Test
    void userInfo() throws Exception {
        mvc.perform(get("/login"))
                .andExpect(status().isOk());
    }

    @Test
    void accessDenied() throws Exception {
        mvc.perform(get("/403"))
                .andExpect(status().isOk());
    }
}