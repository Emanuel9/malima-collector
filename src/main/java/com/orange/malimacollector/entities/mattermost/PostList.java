package com.orange.malimacollector.entities.mattermost;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostList {
    private String[] order;
    private PostsClass posts;

    @JsonProperty("order")
    public String[] getOrder() {
        return order;
    }
    @JsonProperty("order")
    public void setOrder(String[] order) {
        this.order = order;
    }

    @JsonProperty("posts")
    public PostsClass getPosts() {
        return posts;
    }
    @JsonProperty("posts")
    public void setPosts(PostsClass posts) {
        this.posts = posts;
    }
}
