package com.rabbitmq.receiver.event;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EventHandler {

    @RabbitListener(queues = "${receiver.queue}")
    void handleSomethingHappened(final SomethingHappenedEvent event) {
        try {
            System.out.println("Something happened: " + event.getMessage());
        } catch (final Exception e) {
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
