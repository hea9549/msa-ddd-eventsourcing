package com.itchain.samplemsa.samplemsa.eventstore.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoClient extends MongoRepository<EntityWithIdAndEventList, String> {
}
