package com.orange.malimacollector.entities.mattermost;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostsClass {
    private Post property1;
    private Post property2;

    @JsonProperty("property1")
    public Post getProperty1() {
        return property1;
    }
    @JsonProperty("property1")
    public void setProperty1(Post property1) {
        this.property1 = property1;
    }

    @JsonProperty("property2")
    public Post getProperty2() {
        return property2;
    }
    @JsonProperty("property2")
    public void setProperty2(Post property2) {
        this.property2 = property2;
    }
}
