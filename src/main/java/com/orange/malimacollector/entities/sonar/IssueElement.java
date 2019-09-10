package com.orange.malimacollector.entities.sonar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueElement {
    private String key;
    private String component;
    private String project;
    private String rule;
    private String status;
    private String resolution;
    private String severity;
    private String message;
    private long line;
    private String hash;
    private String author;
    private String effort;
    private String creationDate;
    private String updateDate;
    private String[] tags;
    private String type;
    private Comment[] comments;
    private Attr attr;
    private String[] transitions;
    private String[] actions;
    private TextRange textRange;
    private Flow[] flows;

    @JsonProperty("key")
    public String getKey() { return key; }
    @JsonProperty("key")
    public void setKey(String value) { this.key = value; }

    @JsonProperty("component")
    public String getComponent() { return component; }
    @JsonProperty("component")
    public void setComponent(String value) { this.component = value; }

    @JsonProperty("project")
    public String getProject() { return project; }
    @JsonProperty("project")
    public void setProject(String value) { this.project = value; }

    @JsonProperty("rule")
    public String getRule() { return rule; }
    @JsonProperty("rule")
    public void setRule(String value) { this.rule = value; }

    @JsonProperty("status")
    public String getStatus() { return status; }
    @JsonProperty("status")
    public void setStatus(String value) { this.status = value; }

    @JsonProperty("resolution")
    public String getResolution() { return resolution; }
    @JsonProperty("resolution")
    public void setResolution(String value) { this.resolution = value; }

    @JsonProperty("severity")
    public String getSeverity() { return severity; }
    @JsonProperty("severity")
    public void setSeverity(String value) { this.severity = value; }

    @JsonProperty("message")
    public String getMessage() { return message; }
    @JsonProperty("message")
    public void setMessage(String value) { this.message = value; }

    @JsonProperty("line")
    public long getLine() { return line; }
    @JsonProperty("line")
    public void setLine(long value) { this.line = value; }

    @JsonProperty("hash")
    public String getHash() { return hash; }
    @JsonProperty("hash")
    public void setHash(String value) { this.hash = value; }

    @JsonProperty("author")
    public String getAuthor() { return author; }
    @JsonProperty("author")
    public void setAuthor(String value) { this.author = value; }

    @JsonProperty("effort")
    public String getEffort() { return effort; }
    @JsonProperty("effort")
    public void setEffort(String value) { this.effort = value; }

    @JsonProperty("creationDate")
    public String getCreationDate() { return creationDate; }
    @JsonProperty("creationDate")
    public void setCreationDate(String value) { this.creationDate = value; }

    @JsonProperty("updateDate")
    public String getUpdateDate() { return updateDate; }
    @JsonProperty("updateDate")
    public void setUpdateDate(String value) { this.updateDate = value; }

    @JsonProperty("tags")
    public String[] getTags() { return tags; }
    @JsonProperty("tags")
    public void setTags(String[] value) { this.tags = value; }

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("comments")
    public Comment[] getComments() { return comments; }
    @JsonProperty("comments")
    public void setComments(Comment[] value) { this.comments = value; }

    @JsonProperty("attr")
    public Attr getAttr() { return attr; }
    @JsonProperty("attr")
    public void setAttr(Attr value) { this.attr = value; }

    @JsonProperty("transitions")
    public String[] getTransitions() { return transitions; }
    @JsonProperty("transitions")
    public void setTransitions(String[] value) { this.transitions = value; }

    @JsonProperty("actions")
    public String[] getActions() { return actions; }
    @JsonProperty("actions")
    public void setActions(String[] value) { this.actions = value; }

    @JsonProperty("textRange")
    public TextRange getTextRange() { return textRange; }
    @JsonProperty("textRange")
    public void setTextRange(TextRange value) { this.textRange = value; }

    @JsonProperty("flows")
    public Flow[] getFlows() { return flows; }
    @JsonProperty("flows")
    public void setFlows(Flow[] value) { this.flows = value; }
}
