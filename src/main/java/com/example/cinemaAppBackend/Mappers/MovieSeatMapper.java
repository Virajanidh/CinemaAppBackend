package com.example.cinemaAppBackend.Mappers;

import com.example.cinemaAppBackend.JPA.CinemaUserEntity;
import com.example.cinemaAppBackend.JPA.MovieEntity;
import com.example.cinemaAppBackend.JPA.MovieSeatEntity;
import com.example.cinemaAppBackend.JPA.SeatEntity;
import com.example.cinemaAppBackend.Repository.MovieRepository;
import com.example.cinemaAppBackend.Repository.MovieSeatRepository;
import com.example.cinemaAppBackend.Repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MovieSeatMapper {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private MovieSeatRepository movieSeatRepository;

    public MovieSeatEntity mapIn(long price, long movieId, long seatId){
        MovieSeatEntity temp=new MovieSeatEntity();
        temp.setPrice(price);

        Optional seat= seatRepository.findById(seatId);
        if (seat.isPresent()) {
            SeatEntity seatEntity= (SeatEntity) seat.get();
            temp.setSeatEntity(seatEntity);
        } else {
            // Handle the case when cinemaId is not found in the database
        }
        Optional movie=movieRepository.findById(movieId);
        if(movie.isPresent()){
            MovieEntity movieEntity=(MovieEntity) movie.get();
            temp.setMovieEntity(movieEntity);
        }
        else{}
        return temp;
    }
}
