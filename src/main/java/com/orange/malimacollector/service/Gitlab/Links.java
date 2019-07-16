package com.orange.malimacollector.service.Gitlab;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Links {
    private String self;
    private String issues;
    private String mergeRequests;
    private String repoBranches;
    private String labels;
    private String events;
    private String members;

    @JsonProperty("self")
    public String getSelf() { return self; }
    @JsonProperty("self")
    public void setSelf(String value) { this.self = value; }

    @JsonProperty("issues")
    public String getIssues() { return issues; }
    @JsonProperty("issues")
    public void setIssues(String value) { this.issues = value; }

    @JsonProperty("merge_requests")
    public String getMergeRequests() { return mergeRequests; }
    @JsonProperty("merge_requests")
    public void setMergeRequests(String value) { this.mergeRequests = value; }

    @JsonProperty("repo_branches")
    public String getRepoBranches() { return repoBranches; }
    @JsonProperty("repo_branches")
    public void setRepoBranches(String value) { this.repoBranches = value; }

    @JsonProperty("labels")
    public String getLabels() { return labels; }
    @JsonProperty("labels")
    public void setLabels(String value) { this.labels = value; }

    @JsonProperty("events")
    public String getEvents() { return events; }
    @JsonProperty("events")
    public void setEvents(String value) { this.events = value; }

    @JsonProperty("members")
    public String getMembers() { return members; }
    @JsonProperty("members")
    public void setMembers(String value) { this.members = value; }
}
