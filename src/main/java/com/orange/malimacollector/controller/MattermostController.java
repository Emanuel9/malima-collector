package com.orange.malimacollector.controller;

import com.orange.malimacollector.entities.MattermostEntities.Channel;
import com.orange.malimacollector.entities.MattermostEntities.PostList;
import com.orange.malimacollector.entities.MattermostEntities.Teams;
import com.orange.malimacollector.entities.MattermostEntities.User;
import com.orange.malimacollector.service.Mattermost.MattermostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        for (Teams team: teams){
            Channel[] channels = (Channel[]) mattermostService.handler(team);
            model.addAttribute(team.getDisplayName(), channels);
            for (Channel channel: channels){
                PostList posts = (PostList) mattermostService.handler(channel);
                model.addAttribute(channel.getDisplayName(), posts);
            }
        }
        return "MattermostUser";
    }
}
