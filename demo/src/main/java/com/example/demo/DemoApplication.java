package com.example.demo;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	static final String TOPIC_EXCHANGE_NAME = "spring-boot-exchange";

	static final String QUEUE_NAME = "spring-boot";

	@Bean
	Queue queue() {
		return new Queue(DemoApplication.QUEUE_NAME, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(DemoApplication.TOPIC_EXCHANGE_NAME);
	}

	@Bean
	Binding binding(final Queue queue, final TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
	}

	@Bean
	SimpleMessageListenerContainer container(final ConnectionFactory connectionFactory, final MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(DemoApplication.QUEUE_NAME);
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(final Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}

	public static void main(final String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
