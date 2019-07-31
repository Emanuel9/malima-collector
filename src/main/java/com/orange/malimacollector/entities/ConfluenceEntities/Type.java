package com.orange.malimacollector.entities.ConfluenceEntities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

public enum Type {
    PAGE;

    @JsonValue
    public String toValue() {
        switch (this) {
            case PAGE: return "page";
        }
        return null;
    }

    @JsonCreator
    public static Type forValue(String value) throws IOException {
        if (value.equals("page")) return PAGE;
        throw new IOException("Cannot deserialize Type");
    }
}

