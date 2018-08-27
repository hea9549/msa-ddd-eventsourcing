package com.itchain.samplemsa.samplemsa.eventstore.exception;

public class EventIDEmptyException extends EventStoreException{
    public EventIDEmptyException() {
        super("Event ID is empty");
    }
}
