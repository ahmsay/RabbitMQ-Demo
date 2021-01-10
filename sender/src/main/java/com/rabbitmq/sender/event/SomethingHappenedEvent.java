package com.rabbitmq.sender.event;

import java.io.Serializable;

public class SomethingHappenedEvent implements Serializable {

    private String message;

    public SomethingHappenedEvent() { }

    public SomethingHappenedEvent(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
