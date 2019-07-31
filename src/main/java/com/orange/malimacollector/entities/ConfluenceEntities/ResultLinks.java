package com.orange.malimacollector.entities.ConfluenceEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultLinks {
    private String webui;
    private String tinyui;
    private String self;

    @JsonProperty("webui")
    public String getWebui() { return webui; }
    @JsonProperty("webui")
    public void setWebui(String value) { this.webui = value; }

    @JsonProperty("tinyui")
    public String getTinyui() { return tinyui; }
    @JsonProperty("tinyui")
    public void setTinyui(String value) { this.tinyui = value; }

    @JsonProperty("self")
    public String getSelf() { return self; }
    @JsonProperty("self")
    public void setSelf(String value) { this.self = value; }
}