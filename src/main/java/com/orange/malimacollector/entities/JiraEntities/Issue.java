package com.orange.malimacollector.entities.JiraEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue {
    private long maxResults;
    private long startAt;
    private long total;
    private String expand;
    private IssueElement[] issues;

    @JsonProperty("maxResults")
    public long getMaxResults() { return maxResults; }
    @JsonProperty("maxResults")
    public void setMaxResults(long value) { this.maxResults = value; }

    @JsonProperty("startAt")
    public long getStartAt() { return startAt; }
    @JsonProperty("startAt")
    public void setStartAt(long value) { this.startAt = value; }

    @JsonProperty("total")
    public long getTotal() { return total; }
    @JsonProperty("total")
    public void setTotal(long value) { this.total = value; }

    @JsonProperty("expand")
    public String getExpand() { return expand; }
    @JsonProperty("expand")
    public void setExpand(String value) { this.expand = value; }

    @JsonProperty("issues")
    public IssueElement[] getIssues() { return issues; }
    @JsonProperty("issues")
    public void setIssues(IssueElement[] value) { this.issues = value; }
}