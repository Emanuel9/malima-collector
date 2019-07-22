package com.orange.malimacollector.entities;

public class GitLabParameters {
    private boolean projects;
    private boolean group;
    private boolean standalone;
    private boolean hasID;

    public GitLabParameters(boolean projects, boolean group, boolean standalone, boolean hasID) {
        this.projects = projects;
        this.group = group;
        this.standalone = standalone;
        this.hasID = hasID;
    }

    public Object createObject(){
        if (isProjects()) {
            return new Project();
        } else if (isGroup()){
            return new Group();
        } else {
            return new Standalone();
        }
    }

    public boolean isProjects() {
        return projects;
    }

    public boolean isGroup() {
        return group;
    }

    public boolean isStandalone() {
        return standalone;
    }

    public boolean hasID() {
        return hasID;
    }
}