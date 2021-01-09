package com.rabbitmq.receiver.event;

import java.io.Serializable;

public class SomethingHappenedEvent implements Serializable {

    private final String message;

    public SomethingHappenedEvent(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
