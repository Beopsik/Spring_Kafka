package com.example.springkafkalistenercontainer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class SpringKafkaListenerContainerApplication {

	public static Logger logger = LoggerFactory.getLogger(SpringKafkaListenerContainerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaListenerContainerApplication.class, args);

	}

	@KafkaListener(topics = "test", groupId = "test-group", containerFactory = "customContainerFactory")
	public void customListener(String data) {
		logger.info(data);
	}
}
