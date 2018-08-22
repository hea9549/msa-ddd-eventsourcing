package com.itchain.samplemsa.samplemsa.eventstore.domain;

import com.itchain.samplemsa.samplemsa.common.Event;

public interface Store {
    EntityWithIdAndEventList save(String aggregateID, Event event);
    EntityWithIdAndEventList load(String aggregateID);
}
