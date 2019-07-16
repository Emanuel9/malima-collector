package com.orange.malimacollector.service;

public class Group {
    private boolean issues; // /group/:id/issues
    private boolean members; // /group/:id/members
    private boolean mergeRequests; // /group/:id/merge_requests

    public Group(boolean issues, boolean members, boolean mergeRequests) {
        this.issues = issues;
        this.members = members;
        this.mergeRequests = mergeRequests;
    }

    public boolean isIssues() {
        return issues;
    }

    public boolean isMembers() {
        return members;
    }

    public boolean isMergeRequests() {
        return mergeRequests;
    }
}
