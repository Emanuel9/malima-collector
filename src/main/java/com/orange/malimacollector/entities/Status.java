package com.orange.malimacollector.entities;

import javax.persistence.*;

@Entity
@Table(name="Status_Check")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Website_ID", nullable = false)
    private Long websiteID;

    @Column(name="Website_Address", nullable = false, unique = true)
    private String websiteAddress;

    @Column(name="Running", nullable = false)
    private String isRunning;

    public Status() {
    }

    public Status(String websiteAddress) {
        this.websiteAddress = websiteAddress;
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
}
