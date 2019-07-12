package com.orange.malimacollector.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GitlabCollector {
    private URL url; //add the url in terms of the parameters requested

    {
        try {
            url = new URL("http://gitlab.com/api/v4/"); // + parameters(String)
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private URLConnection urlConnection;

    {
        try {
            urlConnection = url.openConnection();
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

}
