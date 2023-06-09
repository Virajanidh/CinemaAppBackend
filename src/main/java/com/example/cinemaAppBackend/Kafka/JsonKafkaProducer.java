package com.example.cinemaAppBackend.Kafka;

import com.example.cinemaAppBackend.DTOs.CinemaUser12;
import com.example.cinemaAppBackend.DTOs.CustomerDTO;
import com.example.cinemaAppBackend.JPA.BookingEntity;
import com.example.cinemaAppBackend.Repository.BookingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    @Value("My_Topic")
    private String topicJsonName;

    @Autowired
    private BookingRepository bookingRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, CinemaUser12> kafkaTemplate;

    @Autowired
    public JsonKafkaProducer(KafkaTemplate<String, CinemaUser12> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(CinemaUser12 data){

        LOGGER.info(String.format("Message sent -> %s", data.toString()));

        Message<CinemaUser12> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "My_Topic_Json")
                .build();

        kafkaTemplate.send(message);
    }

    public void sendCustomerData(CustomerDTO customerDTO){
        LOGGER.info(String.format("Message sent -> %s", customerDTO.toString()));

        Message<CustomerDTO> message = MessageBuilder
                .withPayload(customerDTO)
                .setHeader(KafkaHeaders.TOPIC, "Bookings")
                .build();

        kafkaTemplate.send(message);
    }

    public void validateReservation(BookingEntity bookingEntity){

    }
}
