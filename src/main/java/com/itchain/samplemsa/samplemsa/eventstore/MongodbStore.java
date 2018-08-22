package com.itchain.samplemsa.samplemsa.eventstore;

import com.itchain.samplemsa.samplemsa.common.Event;
import com.itchain.samplemsa.samplemsa.eventstore.domain.EntityWithIdAndEventList;
import com.itchain.samplemsa.samplemsa.eventstore.domain.Store;
import com.itchain.samplemsa.samplemsa.eventstore.domain.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public class MongodbStore implements Store {
    @Autowired
    MongoClient client;

    @Override
    public EntityWithIdAndEventList save(String aggregateID, Event event) {
        EntityWithIdAndEventList entity = load(aggregateID);
        if (entity == null) {
            entity = new EntityWithIdAndEventList();
        }

        entity.addEvent(event);

        return client.save(entity);
    }

    @Override
    public EntityWithIdAndEventList load(String aggregateID) {
        Optional<EntityWithIdAndEventList> option = client.findById(aggregateID);
        if (!option.isPresent()) {
            return null;
        }
        return option.get();
    }
}
