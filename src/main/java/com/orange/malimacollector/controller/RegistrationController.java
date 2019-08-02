package com.orange.malimacollector.controller;

import com.orange.malimacollector.entities.User;
import com.orange.malimacollector.model.Roles;
import com.orange.malimacollector.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {
    @Autowired
    private RegisterService registerService;

    @RequestMapping(method = RequestMethod.GET, value = "/registration")
    public String registerForm(HttpServletRequest request ){
        if ( request.getUserPrincipal() != null ) {
            return "redirect:/";
        }

        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/registration")
    public String register(HttpServletRequest request) throws InterruptedException{
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(email, password, Roles.ROLE_USER);
        try {
            user = registerService.addUser(user);

        } catch (Exception ex){
            throw ex;
        }

        try {
            request.login(user.getEmail(), password);
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
        return "redirect:/";
    }
}
