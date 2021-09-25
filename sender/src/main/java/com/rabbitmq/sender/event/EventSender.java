package com.rabbitmq.sender.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class EventSender {

    private final RabbitTemplate rabbitTemplate;
    private int eventNumber = 1;

    public EventSender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(initialDelay = 1000, fixedDelay = 3000)
    public void sendSomethingHappenedEvent() {
        SomethingHappenedEvent event = new SomethingHappenedEvent(eventNumber, "something happened", LocalTime.now());
        eventNumber++;
        System.out.println("Sending the event...");
        rabbitTemplate.convertAndSend("something.topic", "something.happened", event);
    }
}
