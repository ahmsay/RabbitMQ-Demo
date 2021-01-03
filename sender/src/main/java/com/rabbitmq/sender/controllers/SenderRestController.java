package com.rabbitmq.sender.controllers;

import com.rabbitmq.sender.event.EventDispatcher;
import com.rabbitmq.sender.event.SomethingHappenedEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenderRestController {

    private final EventDispatcher eventDispatcher;

    public SenderRestController(final EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    @GetMapping()
    public String connect() {
        return "Success";
    }

    @PostMapping("/send")
    public String sendEvent(@RequestParam final String message) {
        System.out.println("Sending the event...");
        eventDispatcher.send(new SomethingHappenedEvent(message));
        return "Event is sent.";
    }
}
