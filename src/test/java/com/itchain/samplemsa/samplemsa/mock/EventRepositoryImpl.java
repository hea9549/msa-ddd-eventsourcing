package com.itchain.samplemsa.samplemsa.mock;

import com.itchain.samplemsa.samplemsa.common.Event;
import com.itchain.samplemsa.samplemsa.common.EventRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
