package com.orange.malimacollector.service;

public class GitLabParameters {
    private boolean projects;
    private boolean group;
    private boolean standalone;

    public GitLabParameters(boolean projects, boolean group, boolean standalone) {
        this.projects = projects;
        this.group = group;
        this.standalone = standalone;
    }


}
