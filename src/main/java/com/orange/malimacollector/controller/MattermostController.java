package com.orange.malimacollector.controller;

import com.orange.malimacollector.entities.mattermost.Teams;
import com.orange.malimacollector.entities.mattermost.User;
import com.orange.malimacollector.service.mattermost.MattermostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MattermostController {

    @Autowired
    MattermostService mattermostService;

    @RequestMapping(method = RequestMethod.POST, value = "/MattermostUser")
    public String searchTerms(@RequestParam String searchTerm){
        return "redirect:/MattermostUser?searchTerm=" + searchTerm;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/MattermostUser")
    public String userPage(@RequestParam(value = "searchTerm", required = false) String searchTerm, Model model){
        User user = (User) mattermostService.handler(1);
        model.addAttribute("user", user);
        Teams[] teams = (Teams[]) mattermostService.handler(2);
        model.addAttribute("teams", teams);
        ArrayList<String> posts= new ArrayList<>();
        for (Teams team: teams){
            posts.addAll(mattermostService.handler(searchTerm, team));
        }
        model.addAttribute("posts", posts);
        return "MattermostUser";
    }
}
