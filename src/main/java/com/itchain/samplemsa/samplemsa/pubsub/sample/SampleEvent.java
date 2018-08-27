package com.itchain.samplemsa.samplemsa.pubsub.sample;

import com.itchain.samplemsa.samplemsa.common.Event;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@ToString
public class SampleEvent implements Event {
    private String id;
    private String message;

    public SampleEvent(String id, String message) {
        this.id = id;
        this.message = message;
    }

    @Override
    public String getID() {
        return id;
    }
}
