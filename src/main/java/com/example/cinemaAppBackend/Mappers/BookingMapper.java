package com.example.cinemaAppBackend.Mappers;

import com.example.cinemaAppBackend.DTOs.CustomerDTO;
import com.example.cinemaAppBackend.JPA.*;
import com.example.cinemaAppBackend.Repository.CinemaUserRepository;
import com.example.cinemaAppBackend.Repository.CustomerRepository;
import com.example.cinemaAppBackend.Repository.SeatRepository;
import com.example.cinemaAppBackend.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookingMapper {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CinemaUserRepository cinemaUserRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private SeatRepository seatRepository;

    public BookingEntity mapIn(CustomerDTO customerDTO, long customerId){

        System.out.println("00000000000000000000000000");
        System.out.println(customerId);
        BookingEntity temp=new BookingEntity();
        temp.setNoOfBookedSeats(customerDTO.getNoOfBookedSeats());
        temp.setPaymentId(customerDTO.getPaymentId());

        Optional customer= customerRepository.findById(customerId);
        if (customer.isPresent()) {
            CustomerEntity customerEntity = (CustomerEntity) customer.get();
            temp.setCustomerEntity(customerEntity);
        }
        Optional show= showRepository.findById(customerDTO.getShowId());
        if (show.isPresent()) {
            ShowEntity showEntity = (ShowEntity) show.get();
            temp.setShowEntity(showEntity);
        }
        Optional seat= seatRepository.findById(customerDTO.getSeatId());
        if (seat.isPresent()) {
            SeatEntity seatEntity = (SeatEntity) seat.get();
            temp.setSeatEntity(seatEntity);
        }
        Optional cinemaU= cinemaUserRepository.findById(customerDTO.getCinemaId());
        if (cinemaU.isPresent()) {
            CinemaUserEntity cinemaUser = (CinemaUserEntity) cinemaU.get();
            temp.setCinemaUserEntity(cinemaUser);
        }

        return temp;
    }
}
