package com.example.cinemaAppBackend.Mappers;

import com.example.cinemaAppBackend.DTOs.SeatDTO;
import com.example.cinemaAppBackend.Enums;
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

    public SeatEntity mapIn(Enums.SeatType seatType, int cinemaId, long noOfSeats){
        SeatEntity temp =new SeatEntity();
        temp.setNoOfSeats(noOfSeats);
        temp.setSeatType(seatType);

        Optional cinemaU= cinemaUserRepository.findById(cinemaId);
        if (cinemaU.isPresent()) {
            CinemaUserEntity cinemaUser = (CinemaUserEntity) cinemaU.get();
            temp.setCinemaUserEntity(cinemaUser);
        } else {
            // Handle the case when cinemaId is not found in the database
        }

        return temp;
    }

//

}
