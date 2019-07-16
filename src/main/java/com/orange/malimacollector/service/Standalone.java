package com.orange.malimacollector.service;

public class Standalone {
    private boolean events; // /users/:id/events

    public Standalone(boolean events) {
        this.events = events;
    }

    public boolean isEvents() {
        return events;
    }
}
