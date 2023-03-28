package com.example.cinemaAppBackend.JPA;

import com.example.cinemaAppBackend.Enums;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name="seat")
public class SeatEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seatId;

    private Enums.SeatType seatType;
    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private CinemaUserEntity cinemaUserEntity;

    private long noOfSeats;

    public long getSeatId() {
        return seatId;
    }

    public void setSeatId(long seatId) {
        this.seatId = seatId;
    }

    public Enums.SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(Enums.SeatType seatType) {
        this.seatType = seatType;
    }

    public CinemaUserEntity getCinemaUserEntity() {
        return cinemaUserEntity;
    }

    public void setCinemaUserEntity(CinemaUserEntity cinemaUserEntity) {
        this.cinemaUserEntity = cinemaUserEntity;
    }

    public long getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(long noOfSeats) {
        this.noOfSeats = noOfSeats;
    }
    public SeatEntity(){}

    }

//    public SeatEntity(long seatId, Enums.SeatType seatType, CinemaUserEntity cinemaUserEntity, long noOfSeats) {
//        this.seatId = seatId;
//        this.seatType = seatType;
//        this.cinemaUserEntity = cinemaUserEntity;
//        this.noOfSeats = noOfSeats;
//    }


