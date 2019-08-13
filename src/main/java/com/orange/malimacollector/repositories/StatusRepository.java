package com.orange.malimacollector.repositories;

import com.orange.malimacollector.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Optional<Status> findByWebsiteAddress(String websiteAddress);
}
