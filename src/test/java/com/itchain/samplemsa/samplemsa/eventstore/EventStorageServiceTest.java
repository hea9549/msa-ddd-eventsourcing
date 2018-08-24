package com.itchain.samplemsa.samplemsa.eventstore;

import com.itchain.samplemsa.samplemsa.SampleMsaApplication;
import com.itchain.samplemsa.samplemsa.eventstore.domain.MongoClient;
import com.itchain.samplemsa.samplemsa.eventstore.exception.EventIDEmptyException;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SampleMsaApplication.class)
@TestPropertySource(locations = "classpath:test.properties")
public class EventStorageServiceTest {
    @Autowired
    private MongoClient client;
    @Autowired
    private EventRepository repo;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @After
    public void cleanUp() {
        client.deleteAll();
    }

    @Test
    @DirtiesContext
    public void save_basic() {
        SampleEvent event01 = new SampleEvent("event01");

        repo.save(event01);
    }

    @Test
    public void save_when_event_id_is_not_provided() {
        expectedException.expect(EventIDEmptyException.class);
        expectedException.expectMessage("Event ID is empty");

        SampleEvent event01 = new SampleEvent();
        repo.save(event01);
    }
}
