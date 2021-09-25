package com.rabbitmq.receiver.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Bean
    public TopicExchange somethingTopic() {
        return new TopicExchange("something.topic");
    }

    @Bean
    public Queue somethingQueue() {
        return new Queue("something.queue");
    }

    @Bean
    Binding somethingHappenedBinding() {
        return BindingBuilder.bind(somethingQueue()).to(somethingTopic()).with("something.happened");
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();
        return new Jackson2JsonMessageConverter(mapper);
    }
}
