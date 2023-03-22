package com.example.cinemaAppBackend.Kafka;

import com.example.cinemaAppBackend.DTOs.CinemaUser12;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);


    @KafkaListener(topics = "My_Topic_Json", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(CinemaUser12 user) {
        LOGGER.info(String.format("Json Message received -> %s", user));
    }
}
