package com.rabbitmq.sender.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EventDispatcher {

    private final RabbitTemplate rabbitTemplate;
    private final String senderExchange;
    private final String somethingHappenedRoutingKey;

    public EventDispatcher(final RabbitTemplate rabbitTemplate,
                           @Value("${sender.exchange}") final String senderExchange,
                           @Value("${something.happened.key}") final String somethingHappenedRoutingKey) {
        this.rabbitTemplate = rabbitTemplate;
        this.senderExchange = senderExchange;
        this.somethingHappenedRoutingKey = somethingHappenedRoutingKey;
    }

    public void send(final SomethingHappenedEvent somethingHappenedEvent) {
        rabbitTemplate.convertAndSend(senderExchange, somethingHappenedRoutingKey, somethingHappenedEvent);
    }
}
