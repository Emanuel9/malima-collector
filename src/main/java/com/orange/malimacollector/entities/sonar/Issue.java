package com.orange.malimacollector.entities.sonar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue {
    private Paging paging;
    private IssueElement[] issues;
    private IssueComponent[] components;
    private Rule[] rules;
    private User[] users;

    @JsonProperty("paging")
    public Paging getPaging() { return paging; }
    @JsonProperty("paging")
    public void setPaging(Paging value) { this.paging = value; }

    @JsonProperty("issues")
    public IssueElement[] getIssues() { return issues; }
    @JsonProperty("issues")
    public void setIssues(IssueElement[] value) { this.issues = value; }

    @JsonProperty("components")
    public IssueComponent[] getComponents() { return components; }
    @JsonProperty("components")
    public void setComponents(IssueComponent[] value) { this.components = value; }

    @JsonProperty("rules")
    public Rule[] getRules() { return rules; }
    @JsonProperty("rules")
    public void setRules(Rule[] value) { this.rules = value; }

    @JsonProperty("users")
    public User[] getUsers() { return users; }
    @JsonProperty("users")
    public void setUsers(User[] value) { this.users = value; }
}
