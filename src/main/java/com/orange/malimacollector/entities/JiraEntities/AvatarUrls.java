package com.orange.malimacollector.entities.JiraEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AvatarUrls {
    private String the48X48;
    private String the24X24;
    private String the16X16;
    private String the32X32;

    @JsonProperty("48x48")
    public String getThe48X48() { return the48X48; }
    @JsonProperty("48x48")
    public void setThe48X48(String value) { this.the48X48 = value; }

    @JsonProperty("24x24")
    public String getThe24X24() { return the24X24; }
    @JsonProperty("24x24")
    public void setThe24X24(String value) { this.the24X24 = value; }

    @JsonProperty("16x16")
    public String getThe16X16() { return the16X16; }
    @JsonProperty("16x16")
    public void setThe16X16(String value) { this.the16X16 = value; }

    @JsonProperty("32x32")
    public String getThe32X32() { return the32X32; }
    @JsonProperty("32x32")
    public void setThe32X32(String value) { this.the32X32 = value; }
}
