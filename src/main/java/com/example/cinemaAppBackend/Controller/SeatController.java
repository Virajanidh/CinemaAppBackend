package com.example.cinemaAppBackend.Controller;

import com.example.cinemaAppBackend.DTOs.SeatDTO;
import com.example.cinemaAppBackend.JPA.SeatEntity;
import com.example.cinemaAppBackend.Services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/seat")
@CrossOrigin( allowedHeaders = {})
public class SeatController {
    @Autowired
    private SeatService seatService;

    @GetMapping("/{id}")
    public Optional<SeatEntity> getSeatById(@PathVariable Long id) {
        return seatService.getSeat(id);
    }

    @PostMapping
    public SeatEntity addSeat(@RequestBody SeatDTO seatDTO){
        SeatEntity temp =new SeatEntity();
        try{
            return seatService.addSeat(seatDTO);
        } catch (Exception e){
            System.out.println(e);
            return temp;
        }

    }

    @PutMapping("/{seatId}")
    public SeatEntity updateSeat(@PathVariable("seatId") Long id, @RequestBody SeatDTO seatDTO) {
        SeatEntity temp = new SeatEntity();
        try{
            return seatService.updateSeat(seatDTO,id);
        } catch (Exception e){
            System.out.println(e);
        }
        return temp;
    }

    @DeleteMapping("/{id}")
    public String deleteSeat(@PathVariable("id") long id){
        return seatService.deleteSeat(id);
    }
}
