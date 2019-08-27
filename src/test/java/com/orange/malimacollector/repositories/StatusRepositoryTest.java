package com.orange.malimacollector.repositories;

import com.orange.malimacollector.entities.Status;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StatusRepositoryTest {
    @Autowired
    private StatusRepository statusRepository;

    @Test
    void findByWebsiteAddress() {
        Status status = new Status("test.com", "test");
        status.setRunning("false");
        statusRepository.save(status);
        Status statusTest = statusRepository.findByWebsiteAddress("test.com");
        assertNotNull(status);
        assertEquals(statusTest.getWebsiteName(), status.getWebsiteName());
        assertEquals(statusTest.getWebsiteAddress(), status.getWebsiteAddress());
    }

    @Test
    @Transactional
    void setRunningStatus() {
        Status status = new Status("test.com", "test");
        status.setRunning("false");
        statusRepository.save(status);
        assertNotNull(status);
        statusRepository.setRunningStatus("true", status.getWebsiteID());
        assertEquals("true", statusRepository.findByWebsiteAddress("test.com").isRunning());
    }
}