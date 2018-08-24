package com.itchain.samplemsa.samplemsa.eventstore;

import com.itchain.samplemsa.samplemsa.common.Event;

import java.util.List;

public interface EventRepository {
    public void save(Event event);
    public List<Event> load(String id);
}
