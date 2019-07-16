package com.orange.malimacollector.service;

public class Projects {
    private boolean allProjects; // /users/:id/projects
    private boolean mergeRequests; // /projects/:id/merge_requests
    private boolean allRealese; // /projects/:id/releases

    public Projects(boolean allProjects, boolean mergeRequests, boolean allRealese) {
        this.allProjects = allProjects;
        this.mergeRequests = mergeRequests;
        this.allRealese = allRealese;
    }

    public boolean isAllProjects() {
        return allProjects;
    }

    public boolean isMergeRequests() {
        return mergeRequests;
    }

    public boolean isAllRealese() {
        return allRealese;
    }
}
