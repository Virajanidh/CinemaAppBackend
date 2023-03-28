package com.example.cinemaAppBackend.Services;

import com.example.cinemaAppBackend.DTOs.UpdateSeatDTO;
import com.example.cinemaAppBackend.JPA.MovieEntity;
import com.example.cinemaAppBackend.JPA.SeatEntity;
import com.example.cinemaAppBackend.Mappers.SeatMapper;
import com.example.cinemaAppBackend.Repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private SeatMapper seatMapper;




    public List<Object[]> getSeatDetailsForCinema(int cinemaId){
        return seatRepository.findSeatDetailForCinema(cinemaId);
    }


//    public SeatEntity addSeat(SeatDTO seatDTO){
//        SeatEntity seatEntity =new SeatEntity();
//        seatEntity = seatMapper.mapIn(seatDTO);
//        seatRepository.save(seatEntity);
//        return seatEntity;
//    }
//     public Optional<SeatEntity> getSeat(Long id){
//        return seatRepository.findById(id);
//    }
     public SeatEntity updateSeat(UpdateSeatDTO updateSeatDTO, Long id){

         Optional seat=seatRepository.findById(id);
         if(seat.isPresent()){
             SeatEntity seatEntity=(SeatEntity) seat.get();
             seatEntity.setNoOfSeats(updateSeatDTO.getNoOfSeats());
             seatRepository.save(seatEntity);
             return seatEntity;
         }
         return new SeatEntity();

     }
//
//     public  String deleteSeat(Long id){
//        seatRepository.deleteById(id);
//        return id + " : deleted";
//     }

}
