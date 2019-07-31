package com.orange.malimacollector.entities.JenkinsEntities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JenkinsInfo {
    private String jenkinsInfoClass;
    private AssignedLabel[] assignedLabels;
    private String mode;
    private String nodeDescription;
    private String nodeName;
    private long numExecutors;
    private Object description;
    private PrimaryView[] jobs;
    private OverallLoad overallLoad;
    private PrimaryView primaryView;
    private boolean quietingDown;
    private long slaveAgentPort;
    private UnlabeledLoad unlabeledLoad;
    private boolean useCrumbs;
    private boolean useSecurity;
    private PrimaryView[] views;

    @JsonProperty("_class")
    public String getJenkinsInfoClass() { return jenkinsInfoClass; }
    @JsonProperty("_class")
    public void setJenkinsInfoClass(String value) { this.jenkinsInfoClass = value; }

    @JsonProperty("assignedLabels")
    public AssignedLabel[] getAssignedLabels() { return assignedLabels; }
    @JsonProperty("assignedLabels")
    public void setAssignedLabels(AssignedLabel[] value) { this.assignedLabels = value; }

    @JsonProperty("mode")
    public String getMode() { return mode; }
    @JsonProperty("mode")
    public void setMode(String value) { this.mode = value; }

    @JsonProperty("nodeDescription")
    public String getNodeDescription() { return nodeDescription; }
    @JsonProperty("nodeDescription")
    public void setNodeDescription(String value) { this.nodeDescription = value; }

    @JsonProperty("nodeName")
    public String getNodeName() { return nodeName; }
    @JsonProperty("nodeName")
    public void setNodeName(String value) { this.nodeName = value; }

    @JsonProperty("numExecutors")
    public long getNumExecutors() { return numExecutors; }
    @JsonProperty("numExecutors")
    public void setNumExecutors(long value) { this.numExecutors = value; }

    @JsonProperty("description")
    public Object getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(Object value) { this.description = value; }

    @JsonProperty("jobs")
    public PrimaryView[] getJobs() { return jobs; }
    @JsonProperty("jobs")
    public void setJobs(PrimaryView[] value) { this.jobs = value; }

    @JsonProperty("overallLoad")
    public OverallLoad getOverallLoad() { return overallLoad; }
    @JsonProperty("overallLoad")
    public void setOverallLoad(OverallLoad value) { this.overallLoad = value; }

    @JsonProperty("primaryView")
    public PrimaryView getPrimaryView() { return primaryView; }
    @JsonProperty("primaryView")
    public void setPrimaryView(PrimaryView value) { this.primaryView = value; }

    @JsonProperty("quietingDown")
    public boolean getQuietingDown() { return quietingDown; }
    @JsonProperty("quietingDown")
    public void setQuietingDown(boolean value) { this.quietingDown = value; }

    @JsonProperty("slaveAgentPort")
    public long getSlaveAgentPort() { return slaveAgentPort; }
    @JsonProperty("slaveAgentPort")
    public void setSlaveAgentPort(long value) { this.slaveAgentPort = value; }

    @JsonProperty("unlabeledLoad")
    public UnlabeledLoad getUnlabeledLoad() { return unlabeledLoad; }
    @JsonProperty("unlabeledLoad")
    public void setUnlabeledLoad(UnlabeledLoad value) { this.unlabeledLoad = value; }

    @JsonProperty("useCrumbs")
    public boolean getUseCrumbs() { return useCrumbs; }
    @JsonProperty("useCrumbs")
    public void setUseCrumbs(boolean value) { this.useCrumbs = value; }

    @JsonProperty("useSecurity")
    public boolean getUseSecurity() { return useSecurity; }
    @JsonProperty("useSecurity")
    public void setUseSecurity(boolean value) { this.useSecurity = value; }

    @JsonProperty("views")
    public PrimaryView[] getViews() { return views; }
    @JsonProperty("views")
    public void setViews(PrimaryView[] value) { this.views = value; }
}
