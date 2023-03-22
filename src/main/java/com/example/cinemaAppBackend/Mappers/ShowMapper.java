package com.example.cinemaAppBackend.Mappers;

import com.example.cinemaAppBackend.DTOs.CinemaUserDTO;
import com.example.cinemaAppBackend.DTOs.ShowDTO;
import com.example.cinemaAppBackend.JPA.CinemaUserEntity;
import com.example.cinemaAppBackend.JPA.MovieEntity;
import com.example.cinemaAppBackend.JPA.ShowEntity;
import com.example.cinemaAppBackend.Repository.CinemaUserRepository;
import com.example.cinemaAppBackend.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ShowMapper {

    @Autowired
    private CinemaUserRepository cinemaUserRepository;

    @Autowired
    private MovieRepository movieRepository;

    public ShowEntity mapIn(ShowDTO showDTO){
        ShowEntity temp =new ShowEntity();
        temp.setDate(showDTO.getDate());
        temp.setEndTime(showDTO.getEndTime());
        temp.setStartTime(showDTO.getStartTime());

        Optional cinemaU= cinemaUserRepository.findById(showDTO.getCinemaId());
        if (cinemaU.isPresent()) {
            CinemaUserEntity cinemaUser = (CinemaUserEntity) cinemaU.get();
            temp.setCinemaUserEntity(cinemaUser);
        } else {
            // Handle the case when cinemaId is not found in the database
        }
        Optional movieS= movieRepository.findById(showDTO.getMovieId());
        if (movieS.isPresent()) {
            MovieEntity movieEntity = (MovieEntity) movieS.get();
            temp.setMovieEntity(movieEntity);
        } else {
            // Handle the case when cinemaId is not found in the database
        }

        return temp;
    }

    public ShowDTO mapOut(ShowEntity showEntity){
        ShowDTO temp =new ShowDTO();
        temp.setDate(showEntity.getDate());
        temp.setEndTime(showEntity.getEndTime());
        temp.setStartTime(showEntity.getStartTime());
        temp.setCinemaId(showEntity.getCinemaUserEntity().getCinemaId());
        temp.setMovieId(showEntity.getMovieEntity().getMovieId());
        return temp;
    }
}
