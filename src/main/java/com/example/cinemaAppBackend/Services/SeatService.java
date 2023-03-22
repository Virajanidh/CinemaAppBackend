package com.example.cinemaAppBackend.Services;

import com.example.cinemaAppBackend.DTOs.SeatDTO;
import com.example.cinemaAppBackend.JPA.SeatEntity;
import com.example.cinemaAppBackend.Mappers.SeatMapper;
import com.example.cinemaAppBackend.Repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private SeatMapper seatMapper;


    public SeatEntity addSeat(SeatDTO seatDTO){
        SeatEntity seatEntity =new SeatEntity();
        seatEntity = seatMapper.mapIn(seatDTO);
        seatRepository.save(seatEntity);
        return seatEntity;
    }
     public Optional<SeatEntity> getSeat(Long id){
        return seatRepository.findById(id);
    }
     public SeatEntity updateSeat(SeatDTO seatDTO,Long id){
         SeatEntity seatEntity =new SeatEntity();
         seatEntity = seatMapper.mapIn(seatDTO);
         seatEntity.setSeatId(id);
         seatRepository.save(seatEntity);
         return seatEntity;
     }

     public  String deleteSeat(Long id){
        seatRepository.deleteById(id);
        return id + " : deleted";
     }

}
