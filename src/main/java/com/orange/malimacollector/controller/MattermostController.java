package com.orange.malimacollector.controller;

import com.orange.malimacollector.entities.MattermostEntities.Teams;
import com.orange.malimacollector.entities.MattermostEntities.User;
import com.orange.malimacollector.service.Mattermost.MattermostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class MattermostController {

    @Autowired
    MattermostService mattermostService;

    @RequestMapping(method = RequestMethod.GET, value = "/MattermostUser")
    public String userPage(Model model){
        User user = (User) mattermostService.handler(1);
        model.addAttribute("user", user);
        Teams[] teams = (Teams[]) mattermostService.handler(2);
        model.addAttribute("teams", teams);
        ArrayList<String> posts= new ArrayList<>();
        for (Teams team: teams){
            posts.addAll(mattermostService.handler("test", team));
//            for (Channel channel: channels){
//                System.out.println("Channel " + channel.getName() + " in team " + team.getName());
//                PostList posts = (PostList) mattermostService.handler(channel);
//                System.out.println("One post: " + posts.getPosts().getProperty1().getMessage());
//                model.addAttribute(channel.getDisplayName(), posts);
//            }
        }
        model.addAttribute("posts", posts);
        return "MattermostUser";
    }
}
