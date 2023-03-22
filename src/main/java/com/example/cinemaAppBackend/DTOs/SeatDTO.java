package com.example.cinemaAppBackend.DTOs;

import com.example.cinemaAppBackend.Enums;
import com.example.cinemaAppBackend.JPA.CinemaUserEntity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SeatDTO {

    @NotNull
    @NotEmpty(message = "Seat type required")
    @Enumerated(EnumType.ORDINAL)
    private Enums.SeatType seatType;
    @NotNull
    @NotEmpty(message = "Movie Id required")
    private int cinemaId;
    @NotNull
    @NotEmpty(message = "Number of seats required")
    private long noOfSeats;

    public Enums.SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(Enums.SeatType seatType) {
        this.seatType = seatType;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public long getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(long noOfSeats) {
        this.noOfSeats = noOfSeats;
    }
}
