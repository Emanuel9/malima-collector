package com.orange.malimacollector.entities.confluence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PageLinks {
    private String self;
    private String base;
    private String context;

    @JsonProperty("self")
    public String getSelf() { return self; }
    @JsonProperty("self")
    public void setSelf(String value) { this.self = value; }

    @JsonProperty("base")
    public String getBase() { return base; }
    @JsonProperty("base")
    public void setBase(String value) { this.base = value; }

    @JsonProperty("context")
    public String getContext() { return context; }
    @JsonProperty("context")
    public void setContext(String value) { this.context = value; }
}