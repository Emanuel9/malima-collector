//package com.orange.malimacollector.controller;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
//import org.springframework.web.servlet.View;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//class SonarControllerTest {
//    @InjectMocks
//    SonarController controller;
//
//    @Autowired
//    MockMvc mvc;
//
//    @MockBean
//    View mockView;
//
//    @Before
//    public void setUp() throws Exception{
//        MockitoAnnotations.initMocks(this);
//        StandaloneMockMvcBuilder standaloneMockMvcBuilder = standaloneSetup(controller);
//        standaloneMockMvcBuilder.setSingleView(mockView);
//        mvc = standaloneMockMvcBuilder.build();
//    }
//
//    @Test
//    public void sonarDisplay() throws Exception {
//        mvc.perform(get("/sonar"))
//                .andExpect(status().isOk());
//    }
//}