package com.example.springkafkatemplateproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

@SpringBootApplication
public class SpringKafkaTemplateProducerApplication implements CommandLineRunner {
    private static final String TOPIC_NAME = "test";

    @Autowired
    private KafkaTemplate<String, String> customKafkaTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaTemplateProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ListenableFuture<SendResult<String, String>> future = customKafkaTemplate.send(TOPIC_NAME, "test"); // 전송한 이후에 정상 적재되었는지 여부를 확인
        future.addCallback(new KafkaSendCallback<String, String>() { // 비동기로 적재 여부 확인
            @Override
            public void onSuccess(SendResult<String, String> result) { // 정상 적재되면 호출됨
            }

            @Override
            public void onFailure(KafkaProducerException ex) { // 적재되지 않고 이슈 발생하면 호출됨
            }
        });
        System.exit(0);
    }
}
