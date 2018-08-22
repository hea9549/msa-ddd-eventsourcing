package com.itchain.samplemsa.samplemsa.eventstore;

import com.itchain.samplemsa.samplemsa.SampleEvent;
import com.itchain.samplemsa.samplemsa.SampleMsaApplication;
import com.itchain.samplemsa.samplemsa.eventstore.domain.EntityWithIdAndEventList;
import com.itchain.samplemsa.samplemsa.eventstore.domain.MongoClient;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SampleMsaApplication.class)
@TestPropertySource(locations = "classpath:test.properties")
public class MongodbStoreTest {
    @Autowired
    MongodbStore store;
    @Autowired
    MongoClient client;

    @After
    public void cleanUp() {
        client.deleteAll();
    }


}
