package com.example.cinemaAppBackend.DTOs;

public class UpdatePriceDTO {

    private long movieSeatId;
    private long price;

    public long getMovieSeatId() {
        return movieSeatId;
    }

    public void setMovieSeatId(long movieSeatId) {
        this.movieSeatId = movieSeatId;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
