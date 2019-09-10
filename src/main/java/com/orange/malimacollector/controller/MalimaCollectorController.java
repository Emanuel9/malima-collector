package com.orange.malimacollector.controller;

import com.orange.malimacollector.dao.AppUserDAO;
import com.orange.malimacollector.entities.login.AppUser;
import com.orange.malimacollector.model.AppUserForm;
import com.orange.malimacollector.utils.WebUtils;
import com.orange.malimacollector.validator.AppUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class MalimaCollectorController {
    private static final String REGISTER = "registerPage";
    private static final String USER = "userInfo";

    @Autowired
    private AppUserDAO appUserDAO;

    @Autowired
    private AppUserValidator appUserValidator;

    @InitBinder
    protected void initBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        if (target.getClass() == AppUserForm.class) {
            dataBinder.setValidator(appUserValidator);
        }
    }

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is the welcome page!");
        return "welcomePage";
    }

    @RequestMapping("/members")
    public String viewMembers(Model model) {

        List<AppUser> list = appUserDAO.getAppUsers();

        model.addAttribute("members", list);

        return "membersPage";
    }

    @RequestMapping("/registerSuccessful")
    public String viewRegisterSuccessful(Model model) {

        return "registerSuccessfulPage";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String viewRegister(Model model) {

        AppUserForm form = new AppUserForm();

        model.addAttribute("appUserForm", form);

        return REGISTER;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveRegister(Model model,
                               @ModelAttribute("appUserForm") @Validated AppUserForm appUserForm,
                               BindingResult result,
                               final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return REGISTER;
        }
        AppUser newUser= null;
        try {
            newUser = appUserDAO.createAppUser(appUserForm);
        }
        catch (Exception e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            return REGISTER;
        }

        redirectAttributes.addFlashAttribute("flashUser", newUser);

        return "redirect:/registerSuccessful";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute(USER, userInfo);

        return "adminPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {

        return "loginPage";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute(USER, userInfo);

        return "userInfoPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute(USER, userInfo);

            String message = "Hi " + principal.getName()
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403Page";
    }

}