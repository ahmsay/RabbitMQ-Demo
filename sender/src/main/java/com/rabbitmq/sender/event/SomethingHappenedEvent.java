package com.rabbitmq.sender.event;

import java.time.LocalTime;

public record SomethingHappenedEvent (
        int number,
        String message,
        LocalTime time
) { }
