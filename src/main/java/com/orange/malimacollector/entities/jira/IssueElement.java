package com.orange.malimacollector.entities.jira;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.orange.malimacollector.entities.CommonFields;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueElement extends CommonFields {
    private String expand;
    private Fields fields;
    private String transitions;

    @JsonProperty("expand")
    public String getExpand() { return expand; }
    @JsonProperty("expand")
    public void setExpand(String value) { this.expand = value; }

    @JsonProperty("transitions")
    public String getTransitions() { return transitions; }
    @JsonProperty("transitions")
    public void setTransitions(String value) { this.transitions = value; }

    @JsonProperty("fields")
    public Fields getFields() { return fields; }
    @JsonProperty("fields")
    public void setFields(Fields value) { this.fields = value; }
}
