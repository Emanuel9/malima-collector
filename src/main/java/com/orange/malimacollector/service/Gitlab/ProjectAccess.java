package com.orange.malimacollector.service.Gitlab;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectAccess {
    private long accessLevel;
    private long notificationLevel;

    @JsonProperty("access_level")
    public long getAccessLevel() { return accessLevel; }
    @JsonProperty("access_level")
    public void setAccessLevel(long value) { this.accessLevel = value; }

    @JsonProperty("notification_level")
    public long getNotificationLevel() { return notificationLevel; }
    @JsonProperty("notification_level")
    public void setNotificationLevel(long value) { this.notificationLevel = value; }
}
