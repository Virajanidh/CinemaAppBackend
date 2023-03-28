package com.example.cinemaAppBackend.JPA;

import javax.persistence.*;

@Entity
public class MovieSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movieSeatId;

    private long price;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieEntity movieEntity;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private SeatEntity seatEntity;

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

    public MovieEntity getMovieEntity() {
        return movieEntity;
    }

    public void setMovieEntity(MovieEntity movieEntity) {
        this.movieEntity = movieEntity;
    }

    public SeatEntity getSeatEntity() {
        return seatEntity;
    }

    public void setSeatEntity(SeatEntity seatEntity) {
        this.seatEntity = seatEntity;
    }

    public MovieSeatEntity(){}

}
