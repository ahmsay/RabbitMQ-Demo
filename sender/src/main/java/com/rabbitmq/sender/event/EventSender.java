package com.rabbitmq.sender.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EventSender {

    private final RabbitTemplate rabbitTemplate;
    private final SomethingHappenedEvent event;

    public EventSender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.event = new SomethingHappenedEvent("asd");
    }

    @Scheduled(initialDelay = 1000, fixedDelay = 5000)
    public void sendSomethingHappenedEvent() {
        System.out.println("Sending the event...");
        rabbitTemplate.convertAndSend("something.topic", "something.happened", event);
    }
}
