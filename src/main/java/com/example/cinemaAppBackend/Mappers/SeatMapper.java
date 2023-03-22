package com.example.cinemaAppBackend.Mappers;

import com.example.cinemaAppBackend.DTOs.SeatDTO;
import com.example.cinemaAppBackend.JPA.CinemaUserEntity;
import com.example.cinemaAppBackend.JPA.SeatEntity;
import com.example.cinemaAppBackend.Repository.CinemaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SeatMapper {

    @Autowired
    private CinemaUserRepository cinemaUserRepository;
    public SeatEntity mapIn(SeatDTO seatDTO){
        SeatEntity temp =new SeatEntity();
        temp.setNoOfSeats(seatDTO.getNoOfSeats());
        temp.setSeatType(seatDTO.getSeatType());


        Optional cinemaU= cinemaUserRepository.findById(seatDTO.getCinemaId());
        if (cinemaU.isPresent()) {
            CinemaUserEntity cinemaUser = (CinemaUserEntity) cinemaU.get();
            temp.setCinemaUserEntity(cinemaUser);
        } else {
            // Handle the case when cinemaId is not found in the database
        }


        return temp;
    }
}
