package com.orange.malimacollector.service.Mattermost;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.orange.malimacollector.entities.MattermostEntities.*;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Paths;

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
        String command = "curl -i -d \"{\\\"login_id\\\":\\\"alexm\\\",\\\"password\\\":\\\"AlexMaic97\\\"}\" http://localhost:8065/api/v4/users/login";
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
                .append("/channels/ids");
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

    public static Channel[] postFromJsonString(String json) throws IOException {
        return getPostObjectReader().readValue(json);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateUserMapper() {
        ObjectMapper mapper = new ObjectMapper();
        reader = mapper.reader(User.class);
        writer = mapper.writerFor(User.class);
    }

    private static void instantiateTeamsMapper() {
        ObjectMapper mapper = new ObjectMapper();
        reader = mapper.reader(Teams[].class);
        writer = mapper.writerFor(Teams[].class);
    }

    private static void instantiateChannelMapper() {
        ObjectMapper mapper = new ObjectMapper();
        reader = mapper.reader(Channel[].class);
        writer = mapper.writerFor(Channel[].class);
    }

    private static void instantiatePostMapper() {
        ObjectMapper mapper = new ObjectMapper();
        reader = mapper.reader(PostList.class);
        writer = mapper.writerFor(PostList.class);
    }

    private static ObjectReader getUserObjectReader() {
        if (reader == null) instantiateUserMapper();
        return reader;
    }

    private static ObjectWriter getUserObjectWriter() {
        if (writer == null) instantiateUserMapper();
        return writer;
    }

    private static ObjectReader getTeamsObjectReader() {
        if (reader == null) instantiateTeamsMapper();
        return reader;
    }

    private static ObjectWriter getTeamsObjectWriter() {
        if (writer == null) instantiateTeamsMapper();
        return writer;
    }

    private static ObjectReader getChannelObjectReader() {
        if (reader == null) instantiateChannelMapper();
        return reader;
    }

    private static ObjectWriter getChannelObjectWriter() {
        if (writer == null) instantiateChannelMapper();
        return writer;
    }

    private static ObjectReader getPostObjectReader() {
        if (reader == null) instantiatePostMapper();
        return reader;
    }

    private static ObjectWriter getPostObjectWriter() {
        if (writer == null) instantiatePostMapper();
        return writer;
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
}