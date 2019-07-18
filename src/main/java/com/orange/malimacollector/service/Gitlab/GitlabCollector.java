package com.orange.malimacollector.service.Gitlab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class GitlabCollector {
    private GitLabParameters parameters = new GitLabParameters(true, false, false, true);

    public GitLabParameters getParameters() {
        return parameters;
    }

    public void setParameters(GitLabParameters parameters) {
        this.parameters = parameters;
    }

    public String buildURL(String privateToken, String ID){
        String newURL = "https://gitlab.com/api/v4/";
        String modifier;
        if (parameters.isGroup()){
            modifier = "groups/";
        } else if (parameters.isProjects()){
            modifier = "users/";
        } else {
            modifier = "";
        }
        newURL += modifier;
        if (parameters.hasID()) {
            newURL = newURL + ID + "/";
        }
        newURL += ("projects" + "?private_token=" + privateToken);
        return newURL;
    }

    public String callURL(String myURL) {
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;
        try {
            URL url = new URL(myURL);
            urlConn = url.openConnection();
            if (urlConn != null)
                urlConn.setReadTimeout(60 * 1000);
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(),
                        Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);
                if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                }
            }
            in.close();
        } catch (Exception e) {
            throw new RuntimeException("Exception while calling URL:"+ myURL, e);
        }

        return sb.toString();
    }
}

