package com.example.cinemaAppBackend.JPA;

import com.example.cinemaAppBackend.Enums;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="seat")
public class SeatEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seatId;
    @Enumerated(EnumType.ORDINAL)
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
}

