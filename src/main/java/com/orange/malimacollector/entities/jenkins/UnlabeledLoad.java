package com.orange.malimacollector.entities.jenkins;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UnlabeledLoad {
    private String unlabeledLoadClass;

    @JsonProperty("_class")
    public String getUnlabeledLoadClass() { return unlabeledLoadClass; }
    @JsonProperty("_class")
    public void setUnlabeledLoadClass(String value) { this.unlabeledLoadClass = value; }
}

