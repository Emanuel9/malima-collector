package com.orange.malimacollector.service.Mattermost;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.orange.malimacollector.entities.MattermostEntities.Channel;
import com.orange.malimacollector.entities.MattermostEntities.PostList;
import com.orange.malimacollector.entities.MattermostEntities.Teams;
import com.orange.malimacollector.entities.MattermostEntities.User;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

@Service
public class MattermostService {
    public String buildURL(int choice){
        String newURL = "http://localhost:8065/api/v4/";
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

    public String curlInitializeLogin(){
        String command = "curl -i -d \"{\\\"login_id\\\":\\\"alexm\\\",\\\"password\\\":\\\"mz-789\\\"}\" http://localhost:8065/api/v4/users/login";
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        processBuilder.directory(Paths.get("C:/Windows/System32").toFile());
        try {
            Process process = processBuilder.start();
            StringBuilder sb = new StringBuilder();
            InputStreamReader in = null;
            in = new InputStreamReader(process.getInputStream(), Charset.defaultCharset());
            BufferedReader bufferedReader = new BufferedReader(in);
            if (bufferedReader != null) {
                int cp;
                while ((cp = bufferedReader.read()) != -1) {
                    sb.append((char) cp);
                }
                bufferedReader.close();
            }
            in.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    //function to find token
    public String sessionToken(String response){
        String[] responseParameters = response.split(":");
        boolean breakActive = false;
        for (String parameter: responseParameters){
            String[] lineDiff = parameter.split("\n");
            for (String word: lineDiff){
                if (breakActive){
                    return word;
                }
                if (word.equals("Token")){
                    breakActive = true;
                }
            }
        }
        return null;
    }
    //function to make further curl commands to the api
    public String curlCommands(String URL){
        String token = sessionToken(curlInitializeLogin()).trim();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("curl -H ")
                .append('"')
                .append("Authorization: Bearer")
                .append(" ")
                .append(token)
                .append('"')
                .append(" ")
                .append(URL);
        String command = stringBuilder.toString();
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        processBuilder.directory(Paths.get("C:/Windows/System32").toFile());
        try {
            Process process = processBuilder.start();
            StringBuilder sb = new StringBuilder();
            InputStreamReader in = null;
            in = new InputStreamReader(process.getInputStream(), Charset.defaultCharset());
            BufferedReader bufferedReader = new BufferedReader(in);
            if (bufferedReader != null) {
                int cp;
                while ((cp = bufferedReader.read()) != -1) {
                    sb.append((char) cp);
                }
                bufferedReader.close();
            }
            in.close();
            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String curlCommands(String URL, Teams team){
        String token = sessionToken(curlInitializeLogin()).trim();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("curl -H ")
                .append('"')
                .append("Authorization: Bearer")
                .append(" ")
                .append(token)
                .append('"')
                .append(" ")
                .append(URL);
        stringBuilder
                .append(team.getID())
                .append("/channels");
        String command = stringBuilder.toString();
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        processBuilder.directory(Paths.get("C:/Windows/System32").toFile());
        try {
            Process process = processBuilder.start();
            StringBuilder sb = new StringBuilder();
            InputStreamReader in = null;
            in = new InputStreamReader(process.getInputStream(), Charset.defaultCharset());
            BufferedReader bufferedReader = new BufferedReader(in);
            if (bufferedReader != null) {
                int cp;
                while ((cp = bufferedReader.read()) != -1) {
                    sb.append((char) cp);
                }
                bufferedReader.close();
            }
            in.close();
            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String curlCommands(String URL, Channel channel){
        String token = sessionToken(curlInitializeLogin()).trim();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("curl -H ")
                .append('"')
                .append("Authorization: Bearer")
                .append(" ")
                .append(token)
                .append('"')
                .append(" ")
                .append(URL);
        stringBuilder
                .append(channel.getID())
                .append("/posts");
        String command = stringBuilder.toString();
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        processBuilder.directory(Paths.get("C:/Windows/System32").toFile());
        try {
            Process process = processBuilder.start();
            StringBuilder sb = new StringBuilder();
            InputStreamReader in = null;
            in = new InputStreamReader(process.getInputStream(), Charset.defaultCharset());
            BufferedReader bufferedReader = new BufferedReader(in);
            if (bufferedReader != null) {
                int cp;
                while ((cp = bufferedReader.read()) != -1) {
                    sb.append((char) cp);
                }
                bufferedReader.close();
            }
            in.close();
            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    //search posts in a team
    //curl -d "{\"terms\": \"test\",\"is_or_search\":true,\"time_zone_offset\": 0,\"include_deleted_channels\":true,\"page\": 0,\"per_page\": 60}" -i -X POST -H "Authorization: Bearer sct9g5j18fgazkoau866fn6odw" http://localhost:8065/api/v4/teams/biey6xaoxig9ume363f7qh8ryc/posts/search
    public String curlCommands(String URL, Teams team, String searchTerm) {
        String token = sessionToken(curlInitializeLogin()).trim();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("curl -d \"{\\\"terms\\\": \\\"")
                .append(searchTerm)
                .append("\\\",\\\"is_or_search\\\":true,\\\"time_zone_offset\\\": 0,\\\"include_deleted_channels\\\":true,\\\"page\\\": 0,\\\"per_page\\\": 60}\" -X POST -H \"")
                .append("Authorization: Bearer")
                .append(" ")
                .append(token)
                .append('"')
                .append(" ")
                .append(URL);
        stringBuilder
                .append(team.getID())
                .append("/posts/search");
        String command = stringBuilder.toString();
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        processBuilder.directory(Paths.get("C:/Windows/System32").toFile());
        try {
            Process process = processBuilder.start();
            StringBuilder sb = new StringBuilder();
            InputStreamReader in = null;
            in = new InputStreamReader(process.getInputStream(), Charset.defaultCharset());
            BufferedReader bufferedReader = new BufferedReader(in);
            if (bufferedReader != null) {
                int cp;
                while ((cp = bufferedReader.read()) != -1) {
                    sb.append((char) cp);
                }
                bufferedReader.close();
            }
            in.close();
            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
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
                content = curlCommands(URL);
                try {
                    return userFromJsonString(content);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            case 2:
                URL = buildURL(2);
                content = curlCommands(URL);
                try {
                    return teamsFromJsonString(content);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            default:
                return null;
        }
    }

    public Object handler(Teams team){
        String URL = buildURL(3);
        String content = curlCommands(URL, team);
        try {
            return channelFromJsonString(content);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object handler(Channel channel) {
        String URL = buildURL(4);
        String content = curlCommands(URL, channel);
        try {
            return postFromJsonString(content);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> handler(String searchTerm, Teams team) {
        String URL = buildURL(3);
        ArrayList<String> posts = new ArrayList<>();
        JsonObject o = new JsonParser().parse(curlCommands(URL, team, searchTerm)).getAsJsonObject();

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