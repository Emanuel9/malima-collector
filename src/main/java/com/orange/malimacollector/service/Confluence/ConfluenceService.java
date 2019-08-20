package com.orange.malimacollector.service.Confluence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.orange.malimacollector.config.MachineConfiguration;
import com.orange.malimacollector.entities.ConfluenceEntities.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Paths;

@Service
public class ConfluenceService {
    @Autowired
    private MachineConfiguration config;

    public String buildURL(int choice){
        String newURL = this.config.getWebsites()[0].getLocalAddress();
        switch(choice){
            case 1:
                newURL += "/search";
                break;
            case 2:
                newURL += "";
                break;
        }
        return newURL;
    }

    public String curlCommands(String URL){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("curl -u ").append(this.config.getWebsites()[0].getAdminUsername())
                .append(":").append(this.config.getWebsites()[0].getAdminPassword()).append(" -G \"")
                .append(URL)
                .append("\" --data-urlencode \"cql=(type=page and space=ds)\"");
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

        } catch (
                IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Page pageFromJsonString(String json) throws IOException {
        return getPageReader().readValue(json);
    }

    public static String pageToJsonString(Page obj) throws JsonProcessingException {
        return getPageWriter().writeValueAsString(obj);
    }

    private static ObjectReader pageReader;
    private static ObjectWriter pageWriter;

    private static void instantiatePageMapper() {
        ObjectMapper mapper = new ObjectMapper();
        pageReader = mapper.reader(Page.class);
        pageWriter = mapper.writerFor(Page.class);
    }

    private static ObjectReader getPageReader() {
        if (pageReader == null) instantiatePageMapper();
        return pageReader;
    }

    private static ObjectWriter getPageWriter() {
        if (pageWriter == null) instantiatePageMapper();
        return pageWriter;
    }

    public Object handler(int choice){
        String URL;
        String content;
        switch (choice){
            case 1:
                URL = buildURL(1);
                content = curlCommands(URL);
                try {
                    return pageFromJsonString(content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            case 2:
                URL = buildURL(2);
                content = curlCommands(URL);
                return null; //change to what other requirements there are
            default:
                return null;
        }
    }
}
