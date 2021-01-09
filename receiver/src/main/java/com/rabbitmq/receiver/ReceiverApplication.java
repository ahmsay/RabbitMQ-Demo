package com.rabbitmq.receiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReceiverApplication {

	public static void main(final String[] args) {
		SpringApplication.run(ReceiverApplication.class, args);
	}

}
