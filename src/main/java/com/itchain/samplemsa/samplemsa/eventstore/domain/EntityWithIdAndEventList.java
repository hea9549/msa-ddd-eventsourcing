package com.itchain.samplemsa.samplemsa.eventstore.domain;

import com.itchain.samplemsa.samplemsa.common.Event;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection="event_entity")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class EntityWithIdAndEventList {
    @Id
    private String id;

    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event event) {
        this.eventList.add(event);
    }

    public void appendEventList(List<Event> eventList) {
        this.eventList.addAll(eventList);
    }
}
