package com.orange.malimacollector.entities.SonarEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Attr {
    private String jiraIssueKey;

    @JsonProperty("jira-issue-key")
    public String getJiraIssueKey() { return jiraIssueKey; }
    @JsonProperty("jira-issue-key")
    public void setJiraIssueKey(String value) { this.jiraIssueKey = value; }
}
