package com.itchain.msadddeventsourcing.orderservice.common;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EventRepositoryImpl implements EventRepository {
    List<Event> eventList = new ArrayList<>();
    @Override
    public void save(Event event) {
        eventList.add(event);
    }

    @Override
    public List<Event> load(String id) {
        return eventList;
    }
}
