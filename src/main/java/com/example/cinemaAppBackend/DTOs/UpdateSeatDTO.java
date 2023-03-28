package com.example.cinemaAppBackend.DTOs;

public class UpdateSeatDTO {

    private long seatId;
    private long noOfSeats;

    public long getSeatId() {
        return seatId;
    }

    public void setSeatId(long seatId) {
        this.seatId = seatId;
    }

    public long getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(long noOfSeats) {
        this.noOfSeats = noOfSeats;
    }
}
