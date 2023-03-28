package com.example.cinemaAppBackend.Kafka;

import com.example.cinemaAppBackend.DTOs.CinemaUser12;
import com.example.cinemaAppBackend.DTOs.CustomerDTO;
import com.example.cinemaAppBackend.DTOs.ReserveDTO;
import com.example.cinemaAppBackend.Exceptions.UserAlreadyExistException;
import com.example.cinemaAppBackend.JPA.BookingEntity;
import com.example.cinemaAppBackend.JPA.CinemaUserEntity;
import com.example.cinemaAppBackend.JPA.CustomerEntity;
import com.example.cinemaAppBackend.Mappers.BookingMapper;
import com.example.cinemaAppBackend.Mappers.CustomerMapper;
import com.example.cinemaAppBackend.Repository.BookingRepository;
import com.example.cinemaAppBackend.Repository.CinemaUserRepository;
import com.example.cinemaAppBackend.Repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    private KafkaTemplate<String, ReserveDTO> kafkaTemplate;

    @Autowired
    public JsonKafkaConsumer(KafkaTemplate<String, ReserveDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CinemaUserRepository cinemaUserRepository;


    @KafkaListener(topics = "My_Topic_Json", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(CinemaUser12 user) {
        LOGGER.info(String.format("Json Message received -> %s", user));
    }

    @KafkaListener(topics = "Bookings", groupId = "${spring.kafka.consumer.group-id}")
    public  ResponseEntity<?> consumeBookings(CustomerDTO customerDTO) throws Exception {
        CustomerEntity customerEntity=new CustomerEntity();
        customerEntity=customerMapper.mapIn(customerDTO.getName(), customerDTO.getNic(), customerDTO.getCustomerEmail());

        if(!checkUser(customerDTO.getNic())){
            customerRepository.save(customerEntity);
        }

        long customerId=customerEntity.getCustomerId();
        if(checkIfPaymentExists(customerDTO.getPaymentId())){
            String errorMessage = "Payment already used";
            return ResponseEntity.badRequest().body(errorMessage);
            // throw new UserAlreadyExistException("User already exists for this email");
        }


        int totalSeats= bookingRepository.getDefaultSeatAvailability(customerDTO.getSeatId(),customerDTO.getCinemaId());
        int currentBookings=bookingRepository.getTotalBookedSeats(customerDTO.getShowId(),customerDTO.getSeatId(),customerDTO.getCinemaId());
        System.out.println("00000000000000000000000000");
        System.out.println(totalSeats);
        System.out.println(currentBookings);
        BookingEntity bookingEntity=new BookingEntity();
        if(totalSeats>=(currentBookings+customerDTO.getNoOfBookedSeats())){
            System.out.println("--------------------------------------set");
            bookingEntity=bookingMapper.mapIn(customerDTO,customerId);
            bookingRepository.save(bookingEntity);
            Message<ReserveDTO> message = MessageBuilder
                    .withPayload(new ReserveDTO(customerDTO.getNic(),"Reservation can be done",customerDTO.getPaymentId()))
                    .setHeader(KafkaHeaders.TOPIC, "Bookings_Confirm")
                    .build();
            kafkaTemplate.send(message);
        }
        else{
            System.out.println("Not set");
            Message<ReserveDTO> message = MessageBuilder
                    .withPayload(new ReserveDTO(customerDTO.getNic(),"Reservation cannot proceed.Exceeds the total seats count",customerDTO.getPaymentId()))
                    .setHeader(KafkaHeaders.TOPIC, "Bookings_Confirm")
                    .build();
            kafkaTemplate.send(message);
        }



        return  ResponseEntity.ok(bookingEntity);
       // LOGGER.info(String.format("Json Message received -> %s", bookingEntity));
    }


    public boolean checkIfPaymentExists(long paymentId) {
        return bookingRepository.findByPaymentId(paymentId) !=null ? true : false;
        // return false;
    }
    public boolean checkUser(String nic){
        return customerRepository.findByNic(nic) !=null ? true:false;
    }

    public List<Object[]> getBookingDetails(int cinemaId){
        return bookingRepository.getReservations(cinemaId);
    }
}
