package com.rabbitmq.sender.controllers;

import com.rabbitmq.sender.event.EventDispatcher;
import com.rabbitmq.sender.event.SomethingHappenedEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public String sendEvent(@RequestBody final SomethingHappenedEvent event) {
        System.out.println("Sending the event...");
        eventDispatcher.send(event);
        return "Event is sent.";
    }
}
