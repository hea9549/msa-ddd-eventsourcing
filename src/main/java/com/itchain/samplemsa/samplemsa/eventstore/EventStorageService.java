package com.itchain.samplemsa.samplemsa.eventstore;

import com.itchain.samplemsa.samplemsa.common.Event;
import com.itchain.samplemsa.samplemsa.common.EventRepository;
import com.itchain.samplemsa.samplemsa.eventstore.domain.EntityWithIdAndEventList;
import com.itchain.samplemsa.samplemsa.eventstore.domain.Store;
import com.itchain.samplemsa.samplemsa.eventstore.exception.EventIDEmptyException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventStorageService implements EventRepository {
    private Store store;

    public EventStorageService(Store store) {
        this.store = store;
    }

    @Override
    public void save(Event event) {
        if (isEventIDEmpty(event)) {
            throw new EventIDEmptyException();
        }

        store.save(event.getID(), event);
    }

    private boolean isEventIDEmpty(Event event) {
        String eventID = event.getID();
        return eventID == null || eventID.isEmpty();
    }

    @Override
    public List<Event> load(String id) {
        EntityWithIdAndEventList entity = store.load(id);
        return entity.getEventList();
    }
}
