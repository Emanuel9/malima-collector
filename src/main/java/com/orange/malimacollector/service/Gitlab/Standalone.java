package com.orange.malimacollector.service.Gitlab;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Standalone {
    private boolean events; // /users/:id/events

    @JsonProperty("events")
    public boolean isEvents() {
        return events;
    }
}
