package com.orange.malimacollector.service.mattermost;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.orange.malimacollector.config.MachineConfiguration;
import com.orange.malimacollector.entities.mattermost.Channel;
import com.orange.malimacollector.entities.mattermost.PostList;
import com.orange.malimacollector.entities.mattermost.Teams;
import com.orange.malimacollector.entities.mattermost.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@Service
public class MattermostService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MachineConfiguration config;

    public String buildURL(int choice){
        String newURL = this.config.getWebsites()[4].getLocalAddress();
        switch (choice){
            case 1:
                newURL += "users/me";
                break;
            case 2:
                newURL += "teams";
                break;
            case 3:
                newURL += "teams/";
                break;
            case 4:
                newURL += "channels/";
        }
        return newURL;
    }

    public String getData(String URL){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + this.config.getWebsites()[4].getAdminPassword());
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }

    public String getData(String URL, Teams team, String searchTerm){
        URL += (team.getID() + "/posts/search");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + this.config.getWebsites()[4].getAdminPassword());
        String requestJSON = "{\"terms\": \"" + searchTerm +
                "\",\"is_or_search\":true,\"time_zone_offset\": 0,\"include_deleted_channels\":true,\"page\": 0,\"per_page\": 60}";
        HttpEntity<String> entity = new HttpEntity<String>(requestJSON, headers);
        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.POST, entity, String.class);
        return response.getBody();
    }

    // Serialize/deserialize helpers

    public static User userFromJsonString(String json) throws IOException {
        return getUserObjectReader().readValue(json);
    }

    public static Teams[] teamsFromJsonString(String json) throws IOException {
        return getTeamsObjectReader().readValue(json);
    }

    public static Channel[] channelFromJsonString(String json) throws IOException {
        return getChannelObjectReader().readValue(json);
    }

    public static PostList postFromJsonString(String json) throws IOException {
        return getPostObjectReader().readValue(json);
    }

    private static ObjectReader userReader;
    private static ObjectWriter userWriter;

    private static ObjectReader teamReader;
    private static ObjectWriter teamWriter;

    private static ObjectReader channelReader;
    private static ObjectWriter channelWriter;

    private static ObjectReader postReader;
    private static ObjectWriter postWriter;

    private static void instantiateUserMapper() {
        ObjectMapper mapper = new ObjectMapper();
        userReader = mapper.reader(User.class);
        userWriter = mapper.writerFor(User.class);
    }

    private static void instantiateTeamsMapper() {
        ObjectMapper mapper = new ObjectMapper();
        teamReader = mapper.reader(Teams[].class);
        teamWriter = mapper.writerFor(Teams[].class);
    }

    private static void instantiateChannelMapper() {
        ObjectMapper mapper = new ObjectMapper();
        channelReader = mapper.reader(Channel[].class);
        channelWriter = mapper.writerFor(Channel[].class);
    }

    private static void instantiatePostMapper() {
        ObjectMapper mapper = new ObjectMapper();
        postReader = mapper.reader(PostList.class);
        postWriter = mapper.writerFor(PostList.class);
    }

    private static ObjectReader getUserObjectReader() {
        if (userReader == null) instantiateUserMapper();
        return userReader;
    }

    private static ObjectWriter getUserObjectWriter() {
        if (userWriter == null) instantiateUserMapper();
        return userWriter;
    }

    private static ObjectReader getTeamsObjectReader() {
        if (teamReader == null) instantiateTeamsMapper();
        return teamReader;
    }

    private static ObjectWriter getTeamsObjectWriter() {
        if (teamWriter == null) instantiateTeamsMapper();
        return teamWriter;
    }

    private static ObjectReader getChannelObjectReader() {
        if (channelReader == null) instantiateChannelMapper();
        return channelReader;
    }

    private static ObjectWriter getChannelObjectWriter() {
        if (channelWriter == null) instantiateChannelMapper();
        return channelWriter;
    }

    private static ObjectReader getPostObjectReader() {
        if (postReader == null) instantiatePostMapper();
        return postReader;
    }

    private static ObjectWriter getPostObjectWriter() {
        if (postWriter == null) instantiatePostMapper();
        return postWriter;
    }

    public Object handler(int choice){
        String URL;
        String content;
        switch (choice){
            case 1:
                URL = buildURL(1);
                content = getData(URL);
                try {
                    return userFromJsonString(content);
                } catch (IOException e) {
                    LOGGER.error("Mattermost User Error:" + e.getMessage());
                    return null;
                }
            case 2:
                URL = buildURL(2);
                content = getData(URL);
                try {
                    return teamsFromJsonString(content);
                } catch (IOException e) {
                    LOGGER.error("Mattermost Team Error:" + e.getMessage());
                    return null;
                }
            default:
                return null;
        }
    }

    public Object handler(Teams team){
        String URL = buildURL(3) + team.getID() + "/channels";
        String content = getData(URL);
        try {
            return channelFromJsonString(content);
        } catch (IOException e) {
            LOGGER.error("Mattermost Channel Error:" + e.getMessage());
            return null;
        }
    }

    public Object handler(Channel channel) {
        String URL = buildURL(4) + channel.getID() + "/posts";
        String content = getData(URL);
        try {
            return postFromJsonString(content);
        } catch (IOException e) {
            LOGGER.error("Mattermost Posts Error:" + e.getMessage());
            return null;
        }
    }

    public ArrayList<String> handler(String searchTerm, Teams team) {
        String URL = buildURL(3);
        ArrayList<String> posts = new ArrayList<>();
        JsonObject o = new JsonParser().parse(getData(URL, team, searchTerm)).getAsJsonObject();

        for(Map.Entry<String, JsonElement> entry : o.entrySet()) {
            if (entry.getKey().equals("posts")) {
                JsonObject obj = new JsonParser().parse(entry.getValue().toString()).getAsJsonObject();
                for (Map.Entry<String, JsonElement> val : obj.entrySet()) {
                    JsonObject content = new JsonParser().parse(val.getValue().toString()).getAsJsonObject();
                    for (Map.Entry<String, JsonElement> ct : content.entrySet()) {
                        if (ct.getKey().equals("message")) {
                            posts.add(ct.getValue().toString());
                        }
                    }
                }
            }
        }
        return posts;
    }
}