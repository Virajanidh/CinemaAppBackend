package com.example.cinemaAppBackend.JPA;

import com.example.cinemaAppBackend.Enums;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ShowSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long showSeatId;
//
//    @Column(nullable = false)
//    private BigDecimal price;
//
//    @Enumerated(EnumType.ORDINAL)
//    private Enums.SeatStatus seatStatus;
//
//    @ManyToOne
//    @JoinColumn(name = "show_id")
//    private ShowEntity showEntity;
//
//    @ManyToOne
//    @JoinColumn(name = "seat_id")
//    private SeatEntity seatEntity;
//
//    @ManyToOne
//    @JoinColumn(name = "booking_id")
//    private  MovieEntity movieEntity;
}
