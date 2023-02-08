package com.example.springkafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringKafkaProducerApplication implements CommandLineRunner {

    private static final String TOPIC_NAME = "test";

    @Autowired
    private KafkaTemplate<Integer, String> template;

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            template.send(TOPIC_NAME, "test" + i);
        }
        System.exit(0);
    }
}
