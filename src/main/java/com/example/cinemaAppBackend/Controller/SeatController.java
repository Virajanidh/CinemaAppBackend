package com.example.cinemaAppBackend.Controller;

import com.example.cinemaAppBackend.DTOs.SeatDTO;
import com.example.cinemaAppBackend.DTOs.UpdatePriceDTO;
import com.example.cinemaAppBackend.DTOs.UpdateSeatDTO;
import com.example.cinemaAppBackend.JPA.MovieSeatEntity;
import com.example.cinemaAppBackend.JPA.SeatEntity;
import com.example.cinemaAppBackend.Kafka.JsonKafkaConsumer;
import com.example.cinemaAppBackend.Services.MovieSeatService;
import com.example.cinemaAppBackend.Services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seat")
@CrossOrigin( allowedHeaders = {})
public class SeatController {

    @Autowired
    private MovieSeatService movieSeatService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private JsonKafkaConsumer jsonKafkaConsumer;

    @PostMapping
    public MovieSeatEntity addMovieSeat(@RequestBody SeatDTO seatDTO){
        return movieSeatService.addMovieSeat(seatDTO);
    }

//    @Autowired
//    private SeatService seatService;
//
    @GetMapping("/{id}")
    public List<Object[]> getSeatDetailsForCinema(@PathVariable("id") int id) {
        return seatService.getSeatDetailsForCinema(id);
    }

    @GetMapping("/booking/{id}")
    public List<Object[]> getBookingDetails(@PathVariable("id") int cinemaId ){
        return jsonKafkaConsumer.getBookingDetails(cinemaId);
    }
//    @PostMapping
//    public SeatEntity addSeat(@RequestBody SeatDTO seatDTO){
//        SeatEntity temp =new SeatEntity();
//        try{
//            return seatService.addSeat(seatDTO);
//        } catch (Exception e){
//            System.out.println(e);
//            return temp;
//        }
//
//    }
//
    @PutMapping("/{seatId}")
    public SeatEntity updateSeat(@PathVariable("seatId") Long id, @RequestBody UpdateSeatDTO updateSeatDTO) {
       return seatService.updateSeat(updateSeatDTO,id);
    }

    @PutMapping("/price/{seatId}")
    public MovieSeatEntity updatePrice(@PathVariable("seatId") Long id, @RequestBody UpdatePriceDTO updatePriceDTO) {
        return movieSeatService.updatePrice(updatePriceDTO,id);
    }
//
//    @DeleteMapping("/{id}")
//    public String deleteSeat(@PathVariable("id") long id){
//        return seatService.deleteSeat(id);
//    }
}
