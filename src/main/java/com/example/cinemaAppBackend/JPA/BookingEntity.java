package com.example.cinemaAppBackend.JPA;

import org.springframework.security.access.method.P;

import javax.persistence.*;

public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long bookingId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private PaymentEntity paymentEntity;

}
