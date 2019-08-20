package com.orange.malimacollector.repositories;

import com.orange.malimacollector.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findByWebsiteAddress(String websiteAddress);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Status s set s.isRunning = :isRunning where s.id = :websiteID")
    void setRunningStatus(@Param("isRunning") String isRunning, @Param("websiteID") Long websiteID);
}
