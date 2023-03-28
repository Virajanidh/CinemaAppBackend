package com.example.cinemaAppBackend.Services;

import com.example.cinemaAppBackend.DTOs.SeatDTO;
import com.example.cinemaAppBackend.DTOs.ShowDTO;
import com.example.cinemaAppBackend.DTOs.UpdatePriceDTO;
import com.example.cinemaAppBackend.DTOs.UpdateSeatDTO;
import com.example.cinemaAppBackend.Enums;
import com.example.cinemaAppBackend.JPA.CinemaUserEntity;
import com.example.cinemaAppBackend.JPA.MovieSeatEntity;
import com.example.cinemaAppBackend.JPA.SeatEntity;
import com.example.cinemaAppBackend.Mappers.MovieSeatMapper;
import com.example.cinemaAppBackend.Mappers.SeatMapper;
import com.example.cinemaAppBackend.Repository.MovieSeatRepository;
import com.example.cinemaAppBackend.Repository.SeatRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieSeatService {

    @Autowired
    private MovieSeatRepository movieSeatRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private SeatMapper seatMapper;

    @Autowired
    private MovieSeatMapper movieSeatMapper;

    public MovieSeatEntity addMovieSeat(SeatDTO seatDTO){
        SeatEntity seatEntity=new SeatEntity();
        MovieSeatEntity movieSeatEntity=new MovieSeatEntity();
        for(int i=0;i<3;i++){
            JsonNode jsonObject = seatDTO.getSeatDetails().get(i);
            seatEntity =seatMapper.mapIn(Enums.SeatType.valueOf(jsonObject.get("type").asText()), seatDTO.getCinemaId(),jsonObject.get("noOfSeats").asInt());
            seatRepository.save(seatEntity);
            long seatId=seatEntity.getSeatId();
            movieSeatEntity=movieSeatMapper.mapIn(jsonObject.get("price").asInt(),seatDTO.getMovieId(),seatId);
            movieSeatRepository.save(movieSeatEntity);

        }
        return movieSeatEntity;

    }

    public MovieSeatEntity updatePrice(UpdatePriceDTO updatePriceDTO, Long id){

        Optional seat=movieSeatRepository.findById(id);
        if(seat.isPresent()){
            MovieSeatEntity seatEntity=(MovieSeatEntity) seat.get();
            seatEntity.setPrice(updatePriceDTO.getPrice());
            movieSeatRepository.save(seatEntity);
            return seatEntity;
        }
        return new MovieSeatEntity();

    }
}
