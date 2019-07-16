package com.orange.malimacollector.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;

public class GitlabCollector {
    private URL url; //add the url in terms of the parameters requested
    private String parameters;

    public GitlabCollector(String parameters) {
        this.parameters = parameters;
    }

    {
        try {
            url = new URL("http://gitlab.com/api/v4/" + parameters);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private URLConnection urlConnection;

    {
        try {
            urlConnection = Objects.requireNonNull(url).openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private InputStream inputStream;

    {
        try {
            assert urlConnection != null;
            inputStream = urlConnection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //parse inputStream and post appropriate content on the website

    public InputStream getInputStream() {
        return inputStream;
    }
}
