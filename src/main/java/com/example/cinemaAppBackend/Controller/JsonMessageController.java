package com.example.cinemaAppBackend.Controller;

import com.example.cinemaAppBackend.DTOs.CustomerDTO;
import com.example.cinemaAppBackend.Kafka.JsonKafkaProducer;
import com.example.cinemaAppBackend.DTOs.CinemaUser12;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class JsonMessageController {

    private JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody CinemaUser12 user){
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Message sent to Kafka topic");
    }

    //dummy endpoint
    @PostMapping("/dummyCustomer")
    public ResponseEntity<String> dummyPost(@RequestBody CustomerDTO customerDTO){
        jsonKafkaProducer.sendCustomerData(customerDTO);
        return ResponseEntity.ok("Message sent to Kafka topic");
    }




}
