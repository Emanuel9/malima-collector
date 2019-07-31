package com.orange.malimacollector.entities.JiraEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueElement {
    private String expand;
    private String id;
    private String key;
    private String self;
    private Fields fields;
    private String transitions;

    @JsonProperty("expand")
    public String getExpand() { return expand; }
    @JsonProperty("expand")
    public void setExpand(String value) { this.expand = value; }

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("key")
    public String getKey() { return key; }
    @JsonProperty("key")
    public void setKey(String value) { this.key = value; }

    @JsonProperty("self")
    public String getSelf() { return self; }
    @JsonProperty("self")
    public void setSelf(String value) { this.self = value; }

    @JsonProperty("transitions")
    public String getTransitions() { return transitions; }
    @JsonProperty("transitions")
    public void setTransitions(String value) { this.transitions = value; }

    @JsonProperty("fields")
    public Fields getFields() { return fields; }
    @JsonProperty("fields")
    public void setFields(Fields value) { this.fields = value; }
}
