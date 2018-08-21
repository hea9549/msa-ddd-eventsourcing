package com.itchain.samplemsa.samplemsa.common;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventRepositoryImpl implements EventRepository {
    @Override
    public void save(Event event) {

    }

    @Override
    public List<Event> load(String id) {
        return null;
    }
}
