package com.orange.malimacollector.entities.MattermostEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Timezone {
    private String useAutomaticTimezone;
    private String manualTimezone;
    private String automaticTimezone;

    @JsonProperty("useAutomaticTimezone")
    public String getUseAutomaticTimezone() { return useAutomaticTimezone; }
    @JsonProperty("useAutomaticTimezone")
    public void setUseAutomaticTimezone(String value) { this.useAutomaticTimezone = value; }

    @JsonProperty("manualTimezone")
    public String getManualTimezone() { return manualTimezone; }
    @JsonProperty("manualTimezone")
    public void setManualTimezone(String value) { this.manualTimezone = value; }

    @JsonProperty("automaticTimezone")
    public String getAutomaticTimezone() { return automaticTimezone; }
    @JsonProperty("automaticTimezone")
    public void setAutomaticTimezone(String value) { this.automaticTimezone = value; }
}
