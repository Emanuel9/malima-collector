package com.orange.malimacollector.entities.confluence;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

public enum Space {
    REST_API_SPACE_DS;

    @JsonValue
    public String toValue() {
        switch (this) {
            case REST_API_SPACE_DS: return "/rest/api/space/ds";
        }
        return null;
    }

    @JsonCreator
    public static Space forValue(String value) throws IOException {
        if (value.equals("/rest/api/space/ds")) return REST_API_SPACE_DS;
        throw new IOException("Cannot deserialize Space");
    }
}