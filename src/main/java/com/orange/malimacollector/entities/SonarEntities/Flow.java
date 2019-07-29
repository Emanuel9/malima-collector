package com.orange.malimacollector.entities.SonarEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Flow {
    private Location[] locations;

    @JsonProperty("locations")
    public Location[] getLocations() { return locations; }
    @JsonProperty("locations")
    public void setLocations(Location[] value) { this.locations = value; }
}
