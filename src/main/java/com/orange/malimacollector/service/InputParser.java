package com.orange.malimacollector.service;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class InputParser {
    ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public void gitLabParser(InputStream inputStream){
        String jsonAsString;
//                "{"stringValue":"a","

    }
}
