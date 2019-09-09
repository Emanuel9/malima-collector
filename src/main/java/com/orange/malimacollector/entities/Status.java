package com.orange.malimacollector.entities;

import javax.persistence.*;

@Entity
@Table(name="Status_Check")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Website_ID", nullable = false)
    private Long websiteID;

    @Column(name="Website_Name", nullable = false)
    private String websiteName;

    @Column(name="Website_Address", nullable = false, unique = true)
    private String websiteAddress;

    @Column(name="Running", nullable = false)
    private String isRunning;

    @Transient
    @Column(name="Website_Check", nullable = false)
    private String websiteCheck;

    @Transient
    @Column(name="Website_Index", nullable = false)
    private Integer websiteIndex;

    public Status() {
    }

    public Status(String websiteAddress, String websiteName) {
        this.websiteAddress = websiteAddress;
        this.websiteName = websiteName;
    }

    public Long getWebsiteID() {
        return websiteID;
    }

    public void setWebsiteID(Long websiteID) {
        this.websiteID = websiteID;
    }

    public String getWebsiteAddress() {
        return websiteAddress;
    }

    public void setWebsiteAddress(String websiteAddress) {
        this.websiteAddress = websiteAddress;
    }

    public String isRunning() {
        return isRunning;
    }

    public void setRunning(String running) {
        isRunning = running;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public Integer getWebsiteIndex() {
        return websiteIndex;
    }

    public void setWebsiteIndex(Integer websiteIndex) {
        this.websiteIndex = websiteIndex;
    }

    public String getWebsiteCheck() {
        return websiteCheck;
    }

    public void setWebsiteCheck(String websiteCheck) {
        this.websiteCheck = websiteCheck;
    }
}
