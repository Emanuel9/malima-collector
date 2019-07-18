package com.orange.malimacollector.service.Gitlab;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;

public class InputParser {
    // Serialize/deserialize helpers

    public static Project[] projectFromJsonString(String json) throws IOException {
        return getProjectObjectReader().readValue(json);
    }

    public static String projectToJsonString(Project[] obj) throws JsonProcessingException {
        return getProjectObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateProjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        reader = mapper.reader(Project[].class);
        writer = mapper.writerFor(Project[].class);
    }

    private static ObjectReader getProjectObjectReader() {
        if (reader == null) instantiateProjectMapper();
        return reader;
    }

    private static ObjectWriter getProjectObjectWriter() {
        if (writer == null) instantiateProjectMapper();
        return writer;
    }

    public static Group groupFromJsonString(String json) throws IOException {
        return getGroupObjectReader().readValue(json);
    }

    public static String groupToJsonString(Group obj) throws JsonProcessingException {
        return getGroupObjectWriter().writeValueAsString(obj);
    }

    private static void instantiateGroupMapper() {
        ObjectMapper mapper = new ObjectMapper();
        reader = mapper.reader(Group.class);
        writer = mapper.writerFor(Group.class);
    }

    private static ObjectReader getGroupObjectReader() {
        if (reader == null) instantiateGroupMapper();
        return reader;
    }

    private static ObjectWriter getGroupObjectWriter() {
        if (writer == null) instantiateGroupMapper();
        return writer;
    }

    public Object handler(){
        GitlabCollector gitlabCollector = new GitlabCollector();
        String URL = gitlabCollector.buildURL("8aHcnAb8eVSjauuSkQj7","4278148");
//        System.out.println("URL substring is " + URL.substring(26,27));
        String content = gitlabCollector.callURL(URL);
        if (URL.substring(26,27).equals("p") || URL.substring(26,27).equals("u")){
            try {
                return projectFromJsonString(content);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            try {
                return groupFromJsonString(content);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}

