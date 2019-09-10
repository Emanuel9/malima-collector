package com.orange.malimacollector.entities.sonar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Paging {
    private long pageIndex;
    private long pageSize;
    private long total;

    @JsonProperty("pageIndex")
    public long getPageIndex() { return pageIndex; }
    @JsonProperty("pageIndex")
    public void setPageIndex(long value) { this.pageIndex = value; }

    @JsonProperty("pageSize")
    public long getPageSize() { return pageSize; }
    @JsonProperty("pageSize")
    public void setPageSize(long value) { this.pageSize = value; }

    @JsonProperty("total")
    public long getTotal() { return total; }
    @JsonProperty("total")
    public void setTotal(long value) { this.total = value; }
}
